package com.auth_spring.spring_auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth_spring.spring_auth.entity.UserEntity;
import com.auth_spring.spring_auth.exceptions.AlreadyExistsException;
import com.auth_spring.spring_auth.repository.UserRepository;
import com.auth_spring.spring_auth.request.CreateUserRequest;

@Service
public class UserService implements IUserService {
    @Autowired // Inject
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UserEntity addUser(CreateUserRequest request) {
        return Optional.of(request)
            .filter(user -> !userRepository.existsByEmail(request.getEmail()))
            .map(req -> {
                UserEntity user = new UserEntity();
                user.setName(request.getName());
                user.setEmail((request.getEmail()));
                user.setPassword(encoder.encode(request.getPassword()));
                user.setRoles(request.getRoles());

                return userRepository.save(user);
            }).orElseThrow(() -> new AlreadyExistsException("Error " + request.getEmail() + " already exists!"));
    }

}
