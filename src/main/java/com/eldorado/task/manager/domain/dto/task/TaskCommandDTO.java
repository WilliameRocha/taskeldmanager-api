package com.eldorado.task.manager.domain.dto.task;

import com.eldorado.task.manager.enums.TasksStatusEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TaskCommandDTO {

    @NotNull(message = "User id is required")
    @Min(value = 1, message = "User id must be greater than 0")
    private Long userId;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    @NotNull(message = "Status is required")
    private TasksStatusEnum status;

    @NotNull(message = "Deadline is required")
    private LocalDate deadline;
}
