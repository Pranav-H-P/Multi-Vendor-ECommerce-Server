package com.panic.sasserver.controller;


import com.panic.sasserver.dto.AuthRequestDTO;
import com.panic.sasserver.dto.AuthResponseDTO;
import com.panic.sasserver.dto.RegisterDTO;
import com.panic.sasserver.model.AppUser;
import com.panic.sasserver.repository.UserRepository;
import com.panic.sasserver.service.CustomUserDetailService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.panic.sasserver.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@RestController
@RequestMapping("/api/auth")

public class AuthenticationController {



    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("isAuthenticated()") // requires token to check the token obviously
    @PostMapping("/testtoken") // checks if old token is expired, if not gives a new token to extend session
    public ResponseEntity<AuthResponseDTO> testRefresh(){ // if it throws a forbidden request, it has expired

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        String newJwt = jwtService.generateToken(userEmail);

        return ResponseEntity.ok(new AuthResponseDTO(newJwt, null));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/userdata") // fetches user profile data
    public ResponseEntity<AppUser> getUserData(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        return ResponseEntity.ok(userDetailsService.getUserProfileData(userEmail));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterDTO registerRequest) {
        try {

            String unHashedPswd = registerRequest.getPassword();
            // unhashed has to be passed into authenticationManager.authenticate

            registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            if (!userDetailsService.registerUser(registerRequest)){ // check if user already exists
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(new AuthResponseDTO(null, "User Already Exists!!"));
            }


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(registerRequest.getEmail(),
                            unHashedPswd));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(registerRequest.getEmail());
            String jwt = jwtService.generateToken(userDetails.getUsername()); // using username here because of springboot conventions, actually is email
            return ResponseEntity.ok(new AuthResponseDTO(jwt, null));

        }catch(Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new AuthResponseDTO(null, "Internal error "));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authenticationRequest) { // login logic

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
            String jwt = jwtService.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(new AuthResponseDTO(jwt, null));

        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponseDTO(null, "Invalid username or password " + e.getMessage()));
        }
    }
}