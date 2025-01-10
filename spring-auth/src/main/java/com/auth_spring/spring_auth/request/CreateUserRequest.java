package com.auth_spring.spring_auth.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
	private String email;
	private String password;
	private String roles;
}
