package com.project.project_monitoring.validation.role;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RolesValidator implements ConstraintValidator<ValidRoles, String> {
    // @Override
    // public void initialize(ValidRoles constraintAnnotation) {
    // }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        List<String> roles = Arrays.asList(value.split(",\\s*"));
        
        return roles.contains("admin") || roles.contains("user");
    }

}
