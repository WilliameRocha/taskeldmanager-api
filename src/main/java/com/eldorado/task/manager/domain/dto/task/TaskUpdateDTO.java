package com.eldorado.task.manager.domain.dto.task;

import com.eldorado.task.manager.enums.TasksStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TaskUpdateDTO {
    private Long id;

    private Long userId;

    private String title;

    private TasksStatusEnum status;

    private LocalDate deadline;

    private LocalDateTime createdAt;
}
