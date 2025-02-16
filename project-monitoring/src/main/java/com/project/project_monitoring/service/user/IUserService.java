package com.project.project_monitoring.service.user;

import java.util.List;
import java.util.Optional;

import com.project.project_monitoring.dto.UserDto;
import com.project.project_monitoring.entities.User;
import com.project.project_monitoring.request.CreateUserRequest;

public interface IUserService {
    User addUser (CreateUserRequest request);
    List<User> findAllUser();
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserById(Long id);

    boolean existsByUsername(String username);
    UserDto convertUserToDto(User user);
    List<UserDto> convertedUsersToDto(List<User> users);
}
