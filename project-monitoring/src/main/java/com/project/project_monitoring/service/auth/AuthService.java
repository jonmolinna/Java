package com.project.project_monitoring.service.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.project_monitoring.entities.User;
import com.project.project_monitoring.repository.UserRepository;
import com.project.project_monitoring.service.user.UserInfoDetails;


//
@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(username);

       return user.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    
}

// UserDetailsService --> es el responsable de cargar los datos del usuario de la base de datos
