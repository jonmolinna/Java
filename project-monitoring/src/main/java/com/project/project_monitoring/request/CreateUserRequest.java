package com.project.project_monitoring.request;

import com.project.project_monitoring.validation.role.ValidRoles;
import com.project.project_monitoring.validation.username.UsernameExists;

import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotBlank(message = "Ingrese un nombre")
    @Size(min = 3, max = 50, message = "El nombre del usuario debe tener entre 3 y 50 caracteres")
    private String name;

    @NotBlank(message = "Ingrese un usuario")
    @UsernameExists()
    private String username;

    @NotBlank(message = "Ingrese una contraseña")
    @Size(min = 6, max = 20, message = "La contraseña debe tener entre 6 y 20 caracteres")
    private String password;

    @NotBlank(message = "Ingrese un rol")
    // @Pattern(regexp = "^(admin|user)(,\\s*(admin|user))*$", message = "El rol debe ser 'admin', 'user' o ambos.")
    @ValidRoles()
    private String roles;
}
