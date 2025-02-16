package com.project.project_monitoring.service.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    // Inject
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Metodo para encriptar la contreaseña
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    // Metodo para verificar si la contraseña es correcta
    public boolean comparePassword(String password, String hashPassword) {
        return passwordEncoder.matches(password, hashPassword);
    }
    
}
