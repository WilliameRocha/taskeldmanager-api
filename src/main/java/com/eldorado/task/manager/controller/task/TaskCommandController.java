package com.eldorado.task.manager.controller.task;

import com.eldorado.task.manager.domain.dto.task.TaskCommandDTO;
import com.eldorado.task.manager.domain.task.Task;
import com.eldorado.task.manager.service.command.interfaces.task.ITaskCommandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskCommandController {

    @Autowired
    private ITaskCommandService iTaskCommandService;

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskCommandDTO taskCommandDTO){
        Task task = iTaskCommandService.createTask(taskCommandDTO);
        return ResponseEntity.ok(task);
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateTask(@PathVariable Long id, @Valid @RequestBody TaskCommandDTO taskCommandDTO){
        Boolean updated = iTaskCommandService.updateTask(id, taskCommandDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id){
        Boolean deleted = iTaskCommandService.deleteTask(id);
        return ResponseEntity.ok(deleted);
    }
}
