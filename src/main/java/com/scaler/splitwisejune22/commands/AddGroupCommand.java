package com.scaler.splitwisejune22.commands;

import com.scaler.splitwisejune22.controllers.GroupController;
import com.scaler.splitwisejune22.dtos.AddGroupRequestDto;
import com.scaler.splitwisejune22.dtos.AddGroupResponseDto;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AddGroupCommand implements Command{
    @Autowired
    private GroupController groupController;
    @Override
    public boolean parse(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();

        if (commandTokens.size() != 3) {
            System.out.println("This is not a AddGroup command");
            return false;
        }

        if (!commandTokens.get(1).equalsIgnoreCase(CommandKeywords.Add_Group_Command)) {
            System.out.println("This is not a AddGroup command");
            return false;
        }

        System.out.println("This is a AddGroup command");
        return true;
    }

    @Override
    public void execute(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();

        Long userId = Long.parseLong(commandTokens.get(0));
        String groupName = commandTokens.get(2);

        AddGroupRequestDto requestDto = new AddGroupRequestDto();
        requestDto.setUserId(userId);
        requestDto.setGroupName(groupName);

        AddGroupResponseDto response = groupController.addGroup(requestDto);
        System.out.println(response.getSavedGroup());

    }
}
