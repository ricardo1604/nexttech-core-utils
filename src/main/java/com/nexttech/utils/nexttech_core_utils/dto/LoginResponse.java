package com.nexttech.utils.nexttech_core_utils.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String username;
    private String rol;
    private long expiresIn;
    private String error;
}
