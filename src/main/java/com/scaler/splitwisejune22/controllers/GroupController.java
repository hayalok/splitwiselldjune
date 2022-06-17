package com.scaler.splitwisejune22.controllers;

import com.scaler.splitwisejune22.dtos.AddGroupRequestDto;
import com.scaler.splitwisejune22.dtos.AddGroupResponseDto;
import com.scaler.splitwisejune22.dtos.AddMemberRequestDto;
import com.scaler.splitwisejune22.dtos.AddMemberResponseDto;
import com.scaler.splitwisejune22.exceptions.AddingUserNotAdmin;
import com.scaler.splitwisejune22.models.Group;
import com.scaler.splitwisejune22.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    public AddGroupResponseDto addGroup(AddGroupRequestDto request){
        Group addedGroup = groupService.addGroup(request.getUserId(), request.getGroupName());

        AddGroupResponseDto responseDto = new AddGroupResponseDto();
        responseDto.setSavedGroup(addedGroup);

        return responseDto;
    }

    public AddMemberResponseDto addMember(AddMemberRequestDto request) {


        try {
            Group updatedGroup = groupService.addMember(request.getAddedByAdminUserId(), request.getAddedToGroupId(), request.getAddingMemberUserId());
            AddMemberResponseDto response = new AddMemberResponseDto();
            response.setUpdatedGroup(updatedGroup);
            return response;

        } catch (AddingUserNotAdmin addingUserNotAdmin) {
            System.out.println("Adding user is not admin for this Group"
            );
            return null;
        }

    }
}
