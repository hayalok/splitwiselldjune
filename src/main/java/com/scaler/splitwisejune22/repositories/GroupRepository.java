package com.scaler.splitwisejune22.repositories;

import antlr.collections.List;
import com.scaler.splitwisejune22.models.Group;
import com.scaler.splitwisejune22.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {


    Group save(Group group);

    Group findGroupById(Long id);

    List<Group> findGroupsByParticipantsContaining(User user);
}
