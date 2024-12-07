package com.panic.sasserver.controller;

import com.panic.sasserver.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/customer")
@PreAuthorize("isAuthenticated()")
public class UserController {

    @Autowired
    private CustomUserDetailService userDetailService;

    @PostMapping("/updateAddress")
    public ResponseEntity<String> uploadProfilePicture(@RequestBody String address){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();


        if (userDetailService.updateUserAddress(userEmail, address)){
            return ResponseEntity.ok("ok");
        }else{
            return ResponseEntity.internalServerError().build();
        }
    }
}