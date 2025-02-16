package com.project.project_monitoring.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {
    @NotBlank(message = "Ingrese un usuario")
    private String username;

    @NotBlank(message = "Ingrese una contraseña")
    private String password;
}
