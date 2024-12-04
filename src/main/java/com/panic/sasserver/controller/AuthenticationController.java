package com.panic.sasserver.controller;


import com.panic.sasserver.dto.AuthRequestDTO;
import com.panic.sasserver.dto.AuthResponseDTO;
import com.panic.sasserver.dto.RegisterDTO;
import com.panic.sasserver.service.CustomUserDetailService;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.panic.sasserver.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

            System.out.println(registerRequest.getPassword());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(registerRequest.getEmail(),
                            unHashedPswd));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(registerRequest.getEmail());
            String jwt = jwtService.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(new AuthResponseDTO(jwt, null));

        }catch(Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponseDTO(null, "Invalid username or password " + e.getMessage()));
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