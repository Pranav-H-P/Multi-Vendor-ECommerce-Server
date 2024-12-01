package com.panic.sasserver.dto;

import lombok.Data;

@Data
public class AuthResponseDTO {
    private String jwt;
    private String error;

    public AuthResponseDTO(String jwt, String error) {
        this.jwt = jwt;
        this.error = error;
    }
}
