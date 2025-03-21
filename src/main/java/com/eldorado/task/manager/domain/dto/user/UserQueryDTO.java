package com.eldorado.task.manager.domain.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserQueryDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
