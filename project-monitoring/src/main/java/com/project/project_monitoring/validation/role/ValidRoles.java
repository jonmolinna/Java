package com.project.project_monitoring.validation.role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = RolesValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRoles {
    String message() default "El rol debe ser admin, user o ambos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
