package com.project.project_monitoring.validation.groupname;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
 @Retention(RetentionPolicy.RUNTIME)
 @Constraint(validatedBy = GroupnameExistsValidator.class)
public @interface GroupnameExists {
    String message() default "El nombre del grupo ya está registrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
