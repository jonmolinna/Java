package com.project.project_monitoring.validation.username;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.project_monitoring.service.user.IUserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UsernameExistsValidator implements ConstraintValidator<UsernameExists, String> {
    @Autowired
    private IUserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null) {
            // Si el username es null, no es un error; se validará por separado con otras anotaciones (ej. @NotNull)
            return true;
        }

        return !userService.existsByUsername(username);
    }
}
