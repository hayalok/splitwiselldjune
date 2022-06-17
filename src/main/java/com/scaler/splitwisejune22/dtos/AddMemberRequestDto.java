package com.scaler.splitwisejune22.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberRequestDto {
    private Long addedByAdminUserId;
    private Long addingMemberUserId;
    private Long addedToGroupId;
}
