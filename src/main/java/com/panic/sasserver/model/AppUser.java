package com.panic.sasserver.model;

import com.panic.sasserver.dto.RegisterDTO;
import com.panic.sasserver.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class AppUser{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        @NotBlank
        String name;
        @NotBlank
        String passwordHash;
        @Enumerated
        UserRole role;
        @NotBlank
        @Email
        String email;
        @Positive
        Long phoneNumber;
        Boolean isActive;
        String address;

        public AppUser(String name, String passwdHash, UserRole role, String email, Long phoneNumber,String address, Boolean isActive) {
                this.name = name;
                this.passwordHash = passwdHash;
                this.role = role;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.address = address;
                this.isActive = isActive;
        }
        public AppUser(RegisterDTO newUser){
                this.name = newUser.getName();
                this.passwordHash = newUser.getPassword();
                this.role = newUser.getRole();
                this.email = newUser.getEmail();
                this.phoneNumber = newUser.getPhoneNumber();
                this.isActive = true;
                this.address = newUser.getAddress();
        }

}
