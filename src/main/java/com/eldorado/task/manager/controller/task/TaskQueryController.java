package com.eldorado.task.manager.controller.task;

import com.eldorado.task.manager.domain.dto.task.TaskQueryByStatusRequestDTO;
import com.eldorado.task.manager.domain.dto.task.TaskQueryDTO;
import com.eldorado.task.manager.enums.TasksStatusEnum;
import com.eldorado.task.manager.service.command.interfaces.task.ITaskQueryService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskQueryController {

    @Autowired
    @Qualifier("iTaskQueryServiceDecorator")
    private ITaskQueryService iTaskQueryService;

    @GetMapping
    public ResponseEntity<List<TaskQueryDTO>> getAllTasks(){
        return ResponseEntity.ok(this.iTaskQueryService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskQueryDTO> getTaskById(Long id){
        return this.iTaskQueryService.getTaskById(id)
                                     .map(task -> ResponseEntity.ok().body(task))
                                     .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/bystatus")
    public ResponseEntity<List<TaskQueryDTO>> getTasksByStatus(@RequestParam TasksStatusEnum status
                                                             , @RequestParam String orderBy
                                                             , @RequestParam(required = false, defaultValue = "asc") String orderByDirection){
        TaskQueryByStatusRequestDTO filter = TaskQueryByStatusRequestDTO.builder()
                                                                        .status(status)
                                                                        .orderBy(orderBy)
                                                                        .orderByDirection(orderByDirection)
                                                                        .build();
        return ResponseEntity.ok(this.iTaskQueryService.getTasksByStatus(filter));
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<TaskQueryDTO>> getTasksByUserId(@PathVariable() Long userId){
        return ResponseEntity.ok(this.iTaskQueryService.getTasksByUserId(userId));
    }
}
