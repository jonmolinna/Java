package com.auth_spring.spring_auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.auth_spring.spring_auth.request.AuthRequest;
import com.auth_spring.spring_auth.response.ApiResponse;
import com.auth_spring.spring_auth.service.JwtService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("authentication")
    public ResponseEntity<ApiResponse> athentication(@RequestBody AuthRequest request ) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            
            if (authentication.isAuthenticated()) {
                // return jwtService.generateToken(request.getEmail());
                return ResponseEntity.ok(new ApiResponse("Auth Correct", jwtService.generateToken(request.getEmail())));
            }
            else {
                // throw new UsernameNotFoundException("Invalid user request");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Bad Credentials no error", null));
                
            }
            
        } catch (Exception e) {
            // return "-----------> " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Bad Credentials error", null));
        }        
    }

    @GetMapping("user/profile")
    public String profileUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Obtener los detalles del usuario (usualmente es un objeto UserDetails)
        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof User) {
                User user = (User) principal;
                return "profile authenticate " + user.getUsername();
            }
            
            // Si el principal es un UserDetails, podemos obtener el nombre de usuario y otros detalles

        }
        return "No authenticate";
    }

    @GetMapping("admin/profile")
    // @PreAuthorize("hasAuthority")
    public String profileAdmin() {
        return "Profile Admin";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Bienvido a la ruta libre";
    }   
}
