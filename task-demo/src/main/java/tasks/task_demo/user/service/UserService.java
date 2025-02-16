package tasks.task_demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tasks.task_demo.user.entitY.User;
import tasks.task_demo.user.repository.UserRepository;
import tasks.task_demo.user.request.CreateUserRequest;
import tasks.task_demo.user.validation.role.Role;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User create(CreateUserRequest request) {
        User user = User.builder()
            .name(request.getName())
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();

        return userRepository.save(user);
    }

}