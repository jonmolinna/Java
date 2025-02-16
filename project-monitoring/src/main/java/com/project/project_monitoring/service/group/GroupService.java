package com.project.project_monitoring.service.group;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project_monitoring.entities.Group;
import com.project.project_monitoring.repository.GroupRepository;
import com.project.project_monitoring.request.CreateGroupRequest;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group addGroup(CreateGroupRequest request) {
        Group group = new Group();
        group.setName(request.getName());

        return groupRepository.save(group);
    }

    @Override
    public boolean existsByGroupName(String name) {
        return groupRepository.existsByName(name);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public Group updateGroup(CreateGroupRequest request, Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
        group.setName(request.getName());
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not fpund"));
        groupRepository.delete(group);
    }
}
