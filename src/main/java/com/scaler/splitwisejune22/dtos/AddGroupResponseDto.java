package com.scaler.splitwisejune22.dtos;

import com.scaler.splitwisejune22.models.Group;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddGroupResponseDto {
    private Group savedGroup;
}
