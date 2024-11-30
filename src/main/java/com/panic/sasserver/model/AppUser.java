package com.panic.sasserver.model;

import com.panic.sasserver.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
public record AppUser(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @NotBlank
        String username,
        @NotBlank
        String passwdHash,
        UserRole role,
        @NotBlank
        @Email
        String email,
        @Positive
        Integer phoneNumber,
        Boolean isActive
) {
}
