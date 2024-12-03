package com.panic.sasserver.dto;

import com.panic.sasserver.enums.UserRole;
import lombok.Data;

@Data
public class RegisterDTO {
    String name;
    String password;
    UserRole role;
    String email;
    Long phoneNumber;
    String address;
}
