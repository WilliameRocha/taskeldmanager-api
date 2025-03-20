package com.eldorado.task.manager.domain.dto.task;

import com.eldorado.task.manager.enums.TasksStatusEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskQueryByStatusRequestDTO {

    private TasksStatusEnum status;

    @NotNull(message = "Order by is required")
    @Pattern(regexp = "^(createdAt|deadline)$", message = "Invalid order by field (Valid values: createdAt or deadline)")
    private String orderBy;

    @Pattern(regexp = "^(asc|desc)$", message = "Invalid order by direction (Valid values: ASC or DESC)", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String orderByDirection;
}
