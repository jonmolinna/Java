package com.project.project_monitoring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project_monitoring.entities.Group;
import com.project.project_monitoring.exceptions.ResourceNotFoundException;
import com.project.project_monitoring.request.CreateGroupRequest;
import com.project.project_monitoring.response.ApiResponse;
import com.project.project_monitoring.service.group.IGroupService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/group")
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addGroup(@Valid @RequestBody CreateGroupRequest request) {
        try {
            Group group = groupService.addGroup(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Create Group", group));
    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllGroups() {
        try {
            List<Group> groups = groupService.getAllGroups();
            return new ResponseEntity<ApiResponse>(new ApiResponse("Groups", groups), HttpStatus.OK);            
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null)); 
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getGroupById(@PathVariable Long id) {
        try {
            Optional<Group> groupOptional = groupService.getGroupById(id);

            if (groupOptional.isPresent()) {
                Group group = groupOptional.get();
                return new ResponseEntity<ApiResponse>(new ApiResponse("Group", group), HttpStatus.OK);
            }
            return new ResponseEntity<ApiResponse>(new ApiResponse("Group Not Found", null), HttpStatus.NOT_FOUND);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateGroup(@Valid @RequestBody CreateGroupRequest request, @PathVariable Long id) {
        try {
            Optional<Group> groupOptional = groupService.getGroupById(id);
            if(groupOptional.isPresent()) {
                Group group = groupOptional.get();
                Long idGroup = group.getId();
                Group groupUpdate = groupService.updateGroup(request, idGroup);

                return new ResponseEntity<ApiResponse>(new ApiResponse("Group Update", groupUpdate), HttpStatus.OK);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Group Not Found", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteGroup(@PathVariable Long id) {
        try {
            Optional<Group> grouOptional = groupService.getGroupById(id);

            if (grouOptional.isPresent()) {
                Group group = grouOptional.get();
                groupService.deleteGroup(group.getId());

                return new ResponseEntity<ApiResponse>(new ApiResponse("Delete Group", group), HttpStatus.OK);
            }
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Group Not Found", null));
        } catch (ResourceNotFoundException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }




}
