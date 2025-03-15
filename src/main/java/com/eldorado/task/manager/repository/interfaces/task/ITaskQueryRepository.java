package com.eldorado.task.manager.repository.interfaces.task;

import com.eldorado.task.manager.domain.dto.task.TaskQueryByStatusRequestDTO;
import com.eldorado.task.manager.domain.dto.task.TaskQueryDTO;

import java.util.List;
import java.util.Optional;

public interface ITaskQueryRepository {
    List<TaskQueryDTO> getAllTasks();
    Optional<TaskQueryDTO> getTaskById(Long id);
    List<TaskQueryDTO> getTasksByUserId(Long userId);
    List<TaskQueryDTO> getTasksByStatus(TaskQueryByStatusRequestDTO filter);
}
