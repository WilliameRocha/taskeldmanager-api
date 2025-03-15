package com.eldorado.task.manager.service.command.interfaces.task;

import com.eldorado.task.manager.domain.dto.task.TaskCommandDTO;
import com.eldorado.task.manager.domain.task.Task;

public interface ITaskCommandService {
    Task createTask(TaskCommandDTO taskCommandDTO);
    boolean updateTask(Long id, TaskCommandDTO taskCommandDTO);
    boolean deleteTask(Long taskId);
}
