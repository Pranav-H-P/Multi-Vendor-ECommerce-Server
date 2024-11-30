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
        public AppUser(){

        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPasswdHash() {
                return passwdHash;
        }

        public void setPasswdHash(String passwdHash) {
                this.passwdHash = passwdHash;
        }

        public UserRole getRole() {
                return role;
        }

        public void setRole(UserRole role) {
                this.role = role;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Long getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(Long phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public Boolean getActive() {
                return isActive;
        }

        public void setActive(Boolean active) {
                isActive = active;
        }

}
