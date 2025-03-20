package com.eldorado.task.manager.domain.dto.user;

import jakarta.validation.constraints.*;
import lombok.Builder;

import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserCommandDTO {
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    @NotBlank(message = "Name is required")
    private String firstName;

    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    @NotBlank(message = "Lastname is required")
    private String lastName;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 3, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;
}
