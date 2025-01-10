package com.auth_spring.spring_auth.service;

import com.auth_spring.spring_auth.entity.UserEntity;
import com.auth_spring.spring_auth.request.CreateUserRequest;

public interface IUserService {
    UserEntity addUser(CreateUserRequest request);
}
