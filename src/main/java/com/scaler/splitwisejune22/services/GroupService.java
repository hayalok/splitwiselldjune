package com.scaler.splitwisejune22.services;

import com.scaler.splitwisejune22.exceptions.AddingUserNotAdmin;
import com.scaler.splitwisejune22.models.Group;
import com.scaler.splitwisejune22.models.User;
import com.scaler.splitwisejune22.repositories.GroupRepository;
import com.scaler.splitwisejune22.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository){
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Group addGroup(Long addedByUserId, String groupName){
        User addedByUser = userRepository.findUserById(addedByUserId);
        Group newGroup = new Group();
        newGroup.setName(groupName);
        newGroup.setCreatedBy(addedByUser);
        newGroup.setParticipants(List.of(addedByUser));
        newGroup.setAdmins(List.of(addedByUser));
        Group addedGroup = groupRepository.save(newGroup);
        return addedGroup;
    }

    public Group addMember(Long addedByUserId, Long groupId,Long memberAddedUserId) throws AddingUserNotAdmin {

        Group group = groupRepository.findGroupById(groupId);
        System.out.println(group.getName());
        System.out.println(group.getParticipants());
        Boolean flag = true;

//        for (User admin: group.getAdmins()){
//            if (admin.getId() == (addedByUserId)){
//                flag = true;
//            }
//        }
//        if (flag){
            List<User> participants = group.getParticipants();
            User memberAdded = userRepository.findUserById(memberAddedUserId);
            participants.add(memberAdded);
            group.setParticipants(participants);
            Group updatedGroup = groupRepository.save(group);
            return updatedGroup;
//        }else{
//            System.out.println("Adding user "+addedByUserId+" is not admin of group whose name is "+ group.getName());
//            throw new AddingUserNotAdmin();
//        }

    }
}
