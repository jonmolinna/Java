package com.project.project_monitoring.service.group;

import java.util.List;
import java.util.Optional;

import com.project.project_monitoring.entities.Group;
import com.project.project_monitoring.request.CreateGroupRequest;

public interface IGroupService {
    Group addGroup (CreateGroupRequest request);
    boolean existsByGroupName(String name);
    List<Group> getAllGroups();
    Optional<Group> getGroupById(Long id);
    Group updateGroup(CreateGroupRequest request, Long id);
    void deleteGroup(Long id);
}
