package com.panic.sasserver.model;

import com.panic.sasserver.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
        String username;
        @NotBlank
        String passwdHash;
        UserRole role;
        @NotBlank
        @Email
        String email;
        @Positive
        Long phoneNumber;
        Boolean isActive;

        public AppUser(String username, String passwdHash, UserRole role, String email, Long phoneNumber, Boolean isActive) {
                this.username = username;
                this.passwdHash = passwdHash;
                this.role = role;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.isActive = isActive;
        }

}
