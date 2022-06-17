package com.scaler.splitwisejune22.commands;

import com.scaler.splitwisejune22.controllers.GroupController;
import com.scaler.splitwisejune22.dtos.AddMemberRequestDto;
import com.scaler.splitwisejune22.dtos.AddMemberResponseDto;
import com.scaler.splitwisejune22.exceptions.AddingUserNotAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AddMemberCommand implements Command{

    @Autowired
    private GroupController groupController;
    @Override
    public boolean parse(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();

        if (commandTokens.size() != 4) {
            System.out.println("This is not a AddMember command");
            return false;
        }

        if (!commandTokens.get(1).equalsIgnoreCase(CommandKeywords.Add_Member_Command)) {
            System.out.println("This is not a AddMember command");
            return false;
        }

        System.out.println("This is a AddMember command");
        return true;
    }

    @Override
    public void execute(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
        AddMemberRequestDto requestDto = new AddMemberRequestDto();

        Long addingAdminUserId = Long.parseLong(commandTokens.get(0));
        Long addedToGroupId = Long.parseLong(commandTokens.get(2));
        Long memberAddedUserId = Long.parseLong(commandTokens.get(3));

        requestDto.setAddingMemberUserId(memberAddedUserId);
        requestDto.setAddedByAdminUserId(addingAdminUserId);
        requestDto.setAddedToGroupId(addedToGroupId);

        AddMemberResponseDto response = groupController.addMember(requestDto);
        if (response!= null){
            System.out.println(response.getUpdatedGroup().toString());
        }




    }
}
