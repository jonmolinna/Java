package com.project.project_monitoring.validation.username;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER }) // Aplica a los campos y parámetros
@Retention(RetentionPolicy.RUNTIME) // La anotación estará disponible en tiempo de ejecución
@Constraint(validatedBy = UsernameExistsValidator.class) // El validador asociado
public @interface UsernameExists {
    // Mensaje por defecto
    String message() default "El username ya está registrado";

    // Grupos de validación (si es necesario)
    Class<?>[] groups() default {};

    // Cualquier dato adicional (si es necesario)
    Class<? extends Payload>[] payload() default {};
}
