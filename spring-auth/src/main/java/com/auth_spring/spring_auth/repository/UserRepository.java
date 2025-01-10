package com.auth_spring.spring_auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.auth_spring.spring_auth.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);

    UserEntity findByEmail(String email);
}
