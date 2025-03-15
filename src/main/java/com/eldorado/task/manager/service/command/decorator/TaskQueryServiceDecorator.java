package com.eldorado.task.manager.service.command.decorator;

import com.eldorado.task.manager.domain.dto.task.TaskQueryByStatusRequestDTO;
import com.eldorado.task.manager.domain.dto.task.TaskQueryDTO;
import com.eldorado.task.manager.service.command.interfaces.task.ITaskQueryService;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component("iTaskQueryServiceDecorator")
public class TaskQueryServiceDecorator implements ITaskQueryService {

    @Autowired
    @Qualifier("iTaskQueryService")
    private ITaskQueryService next;

    @Override
    public List<TaskQueryDTO> getAllTasks() {
        return next.getAllTasks();
    }

    @Override
    public Optional<TaskQueryDTO> getTaskById(Long id) {
        return next.getTaskById(id);
    }

    @Override
    public List<TaskQueryDTO> getTasksByUserId(Long userId) {
        return next.getTasksByUserId(userId);
    }

    @Override
    public List<TaskQueryDTO> getTasksByStatus(TaskQueryByStatusRequestDTO filter) {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<TaskQueryByStatusRequestDTO>> violations = validator.validate(filter);

        if(!violations.isEmpty()){
            String message = violations.stream().findFirst().get().getMessage();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }

        return next.getTasksByStatus(filter);
    }
}
