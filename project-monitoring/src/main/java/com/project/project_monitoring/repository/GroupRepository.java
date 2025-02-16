package com.project.project_monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project_monitoring.entities.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    boolean existsByName(String name);
}
