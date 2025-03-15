package com.eldorado.task.manager.service.command.task;

import com.eldorado.task.manager.domain.dto.task.TaskCommandDTO;
import com.eldorado.task.manager.domain.task.Task;
import com.eldorado.task.manager.repository.interfaces.task.ITaskCommandRepository;
import com.eldorado.task.manager.service.command.interfaces.task.ITaskCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskCommandService implements ITaskCommandService {

    @Autowired
    private ITaskCommandRepository iTaskCommandRepository;

    @Override
    public Task createTask(TaskCommandDTO taskCommandDTO) {
        return this.iTaskCommandRepository.createTask(taskCommandDTO);
    }

    @Override
    public boolean updateTask(Long id, TaskCommandDTO taskCommandDTO) {
        return this.iTaskCommandRepository.updateTask(id, taskCommandDTO);
    }

    @Override
    public boolean deleteTask(Long taskId) {
        return this.iTaskCommandRepository.deleteTask(taskId);
    }
}
