package com.project.project_monitoring.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project_monitoring.component.JwtUtil;
import com.project.project_monitoring.entities.User;
import com.project.project_monitoring.request.AuthRequest;
import com.project.project_monitoring.response.ApiResponse;
import com.project.project_monitoring.service.password.PasswordService;
import com.project.project_monitoring.service.user.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("login")
    public ResponseEntity<ApiResponse> authentication(@Valid @RequestBody AuthRequest request) {
        try {
            Optional<User> userOptional = userService.findUserByUsername(request.getUsername());

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                String hashPassword = user.getPassword();
                String username = user.getUsername();
                boolean isMatch = passwordService.comparePassword(request.getPassword(), hashPassword);

                if (isMatch) {
                    String token = jwtUtil.generateToken(username);
                    HashMap<String, String> response = new HashMap<>();
                    response.put("access_token", token);

                    return  ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Create Token", response));
                }

                return  new ResponseEntity<ApiResponse>(new ApiResponse("Credenciales Incorrecta", null), HttpStatus.UNAUTHORIZED);
            }
                
            return  new ResponseEntity<ApiResponse>(new ApiResponse("Credenciales Incorrecta", null), HttpStatus.UNAUTHORIZED);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(e.getMessage(), null));
        }
    }

}
