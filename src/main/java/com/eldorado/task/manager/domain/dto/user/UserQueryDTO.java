package com.eldorado.task.manager.domain.dto.user;

import lombok.Builder;

@Builder
public class UserQueryDTO {
    private Long id;

    private String name;

    private String email;
}
