package com.auth_spring.spring_auth.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
