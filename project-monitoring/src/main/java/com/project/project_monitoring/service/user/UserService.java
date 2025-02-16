package com.project.project_monitoring.service.user;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project_monitoring.dto.UserDto;
import com.project.project_monitoring.entities.User;
import com.project.project_monitoring.repository.UserRepository;
import com.project.project_monitoring.request.CreateUserRequest;
import com.project.project_monitoring.service.password.PasswordService;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordService passwordService;

    @Override
    public User addUser(CreateUserRequest request) {
        String hash = passwordService.encryptPassword(request.getPassword());

        User user = new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setRoles(request.getRoles());
        user.setPassword(hash);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDto convertUserToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> convertedUsersToDto(List<User> users) {
        return users.stream().map(this::convertUserToDto).toList();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
