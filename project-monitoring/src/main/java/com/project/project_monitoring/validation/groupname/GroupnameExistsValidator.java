package com.project.project_monitoring.validation.groupname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.project_monitoring.service.group.IGroupService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class GroupnameExistsValidator implements ConstraintValidator<GroupnameExists, String> {
    @Autowired
    private IGroupService groupService;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (name == null) {
            return true;
        }

        return !groupService.existsByGroupName(name);
    }
    

}
