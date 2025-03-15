package com.eldorado.task.manager.repository.interfaces.task;

import com.eldorado.task.manager.domain.dto.task.TaskCommandDTO;
import com.eldorado.task.manager.domain.task.Task;

public interface ITaskCommandRepository {
    Task createTask(TaskCommandDTO taskCommandDTO);
    boolean updateTask(Long id, TaskCommandDTO taskCommandDTO);
    boolean deleteTask(Long taskId);
}
