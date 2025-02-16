package com.project.project_monitoring.request;

import com.project.project_monitoring.validation.groupname.GroupnameExists;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateGroupRequest {
    @NotBlank(message = "Ingrese un grupo")
    @Size(min = 3, max = 50, message = "El nombre del grupo debe tener entre 3 y 50 caracteres")
    @GroupnameExists()
    private String name;
}
