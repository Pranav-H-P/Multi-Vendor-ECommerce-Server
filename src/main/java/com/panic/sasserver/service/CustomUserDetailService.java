package com.panic.sasserver.service;


import java.time.LocalDate;
import java.util.Collections;

import com.panic.sasserver.dto.RegisterDTO;
import com.panic.sasserver.enums.UserRole;
import com.panic.sasserver.enums.VendorStatus;
import com.panic.sasserver.model.AppUser;
import com.panic.sasserver.model.Vendor;
import com.panic.sasserver.repository.UserRepository;
import com.panic.sasserver.repository.VendorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userDB;

    @Autowired
    private VendorRepository vendorDB;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = userDB.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new org.springframework.security.core.userdetails.User(
                email, user.getPasswordHash(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())));
    }

    public boolean userExistsByEmail(String email){

        AppUser user = userDB.findByEmail(email);

        return user != null;
    }

    @Transactional
    public boolean registerUser(RegisterDTO newUser){

        if (userExistsByEmail(newUser.getEmail())){
            return false;
        }



        AppUser user = new AppUser(newUser);
        userDB.save(user);

        if (newUser.getRole() == UserRole.VENDOR){
            Vendor vendor = new Vendor(user.getId(),
                    user.getName(),
                    user.getEmail() + "," + user.getPhoneNumber(),
                    "",
                    VendorStatus.PENDING,
                    LocalDate.now());

            vendorDB.save(vendor);
        }


        return true;
    }

    public AppUser getUserProfileData(String email){

        AppUser user = userDB.findByEmail(email);
        user.setPasswordHash("lol");

        return user;
    }



    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        AppUser user = userDB.findByEmail(userEmail);

        return user.getId();
    }

    @Transactional
    public Integer updateCurrentUserAddress(String address) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userDB.updateAddressByEmail(email, address);
    }
}