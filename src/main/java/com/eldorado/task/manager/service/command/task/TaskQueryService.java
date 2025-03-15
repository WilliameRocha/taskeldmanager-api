package com.eldorado.task.manager.service.command.task;

import com.eldorado.task.manager.domain.dto.task.TaskQueryByStatusRequestDTO;
import com.eldorado.task.manager.domain.dto.task.TaskQueryDTO;
import com.eldorado.task.manager.repository.interfaces.task.ITaskQueryRepository;
import com.eldorado.task.manager.service.command.interfaces.task.ITaskQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("iTaskQueryService")
public class TaskQueryService implements ITaskQueryService {

    @Autowired
    private ITaskQueryRepository iTaskQueryRepository;

    @Override
    public List<TaskQueryDTO> getAllTasks() {
        return this.iTaskQueryRepository.getAllTasks();
    }

    @Override
    public Optional<TaskQueryDTO> getTaskById(Long id) {
        Objects.requireNonNull(id, "The id must not be null");
        if(id <= 0){
            throw new IllegalArgumentException("The id must be greater than 0");
        }
        return this.iTaskQueryRepository.getTaskById(id);
    }

    @Override
    public List<TaskQueryDTO> getTasksByUserId(Long userId) {
        Objects.requireNonNull(userId, "The userId must not be null");
        if(userId <= 0){
            throw new IllegalArgumentException("The userId must be greater than 0");
        }
        return this.iTaskQueryRepository.getTasksByUserId(userId);
    }

    @Override
    public List<TaskQueryDTO> getTasksByStatus(TaskQueryByStatusRequestDTO filter) {
        return this.iTaskQueryRepository.getTasksByStatus(filter);
    }
}
