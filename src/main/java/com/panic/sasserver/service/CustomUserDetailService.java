package com.panic.sasserver.service;


import java.util.Collections;

import com.panic.sasserver.dto.RegisterDTO;
import com.panic.sasserver.model.AppUser;
import com.panic.sasserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        System.out.println(user.getRole().name());
        return new org.springframework.security.core.userdetails.User(
                email, user.getPasswordHash(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())));
    }

    public boolean userExistsByEmail(String email){

        AppUser user = userRepository.findByEmail(email);

        return user != null;
    }

    public boolean registerUser(RegisterDTO newUser){

        if (userExistsByEmail(newUser.getEmail())){
            return false;
        }

        AppUser user = new AppUser(newUser);
        userRepository.save(user);
        return true;
    }

}