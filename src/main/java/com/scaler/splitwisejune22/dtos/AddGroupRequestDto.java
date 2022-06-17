package com.scaler.splitwisejune22.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddGroupRequestDto {
    private Long userId;
    private String groupName;
}
