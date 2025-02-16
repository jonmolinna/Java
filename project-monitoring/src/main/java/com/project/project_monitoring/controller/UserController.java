package com.project.project_monitoring.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project_monitoring.dto.UserDto;
import com.project.project_monitoring.entities.User;
import com.project.project_monitoring.exceptions.ResourceNotFoundException;
import com.project.project_monitoring.request.CreateUserRequest;
import com.project.project_monitoring.response.ApiResponse;
import com.project.project_monitoring.service.user.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addUser(@Valid @RequestBody CreateUserRequest request) {
        try {
            User user = userService.addUser(request);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Created User Success", userDto));
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @Secured({"admin"})
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllUsers() {
        try {
            List<User> users = userService.findAllUser();
            List<UserDto> usersDto = userService.convertedUsersToDto(users);

            return new ResponseEntity<ApiResponse>(new ApiResponse("Users", usersDto), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @Secured({"admin", "user"})
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id, Authentication authentication) {
        try {
            String username = authentication.getName();
            Optional<User> userOptional = userService.findUserById(id);

            if (userOptional.isPresent()) {
                User user = userOptional.get();

                boolean contains = Arrays.stream(authentication.getAuthorities().toArray()).anyMatch("admin"::equals);

                System.out.println("--------->" + contains);
                System.out.println("role auth --------->" + authentication.getAuthorities());
                System.out.println("type role auth --------->" + authentication.getAuthorities().toArray());

                UserDto userDto = userService.convertUserToDto(user);
                return new ResponseEntity<ApiResponse>(new ApiResponse("User", userDto), HttpStatus.OK);

            }
            
            return new ResponseEntity<ApiResponse>(new ApiResponse("User Not Found", null), HttpStatus.NOT_FOUND);
            
        } catch (ResourceNotFoundException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}



// @RestController
// public class MyController {

//     // Endpoint para obtener información de un usuario por ID
//     @Secured({"ROLE_ADMIN", "ROLE_USER"})
//     @GetMapping("/user/{id}")
//     public String getUserInfo(@PathVariable("id") Long id, @AuthenticationPrincipal User authenticatedUser) {
//         // Obtener el ID del usuario autenticado
//         Long authenticatedUserId = Long.valueOf(authenticatedUser.getUsername()); // Suponiendo que el username es el ID

//         // Verificar si el usuario autenticado es el mismo que el que solicita el recurso
//         if ("ROLE_USER".equals(authenticatedUser.getAuthorities().toArray()[0]) && authenticatedUserId.equals(id)) {
//             return "Acceso permitido para el usuario con ID: " + id;
//         } else if ("ROLE_ADMIN".equals(authenticatedUser.getAuthorities().toArray()[0])) {
//             return "Acceso permitido para el admin, accediendo al ID: " + id;
//         } else {
//             // Si el usuario autenticado no es el que corresponde
//             throw new AccessDeniedException("No tienes permisos para acceder a este recurso.");
//         }
//     }
// }
