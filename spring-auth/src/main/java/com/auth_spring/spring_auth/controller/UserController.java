package com.auth_spring.spring_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_spring.spring_auth.entity.UserEntity;
import com.auth_spring.spring_auth.request.CreateUserRequest;
import com.auth_spring.spring_auth.response.ApiResponse;
import com.auth_spring.spring_auth.service.IUserService;
import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired // Inject
    private IUserService userService;

    @PostMapping("add")
    public ResponseEntity<ApiResponse> addUser(@RequestBody CreateUserRequest request) {
        try {
            UserEntity user = userService.addUser(request);

            return ResponseEntity.ok(new ApiResponse("Created User Success", user));
        } catch (Exception e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
