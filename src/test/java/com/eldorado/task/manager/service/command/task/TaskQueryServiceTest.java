package com.eldorado.task.manager.service.command.task;

import com.eldorado.task.manager.TaskEldManagerApplicationTests;
import com.eldorado.task.manager.domain.dto.task.TaskCommandDTO;
import com.eldorado.task.manager.domain.dto.task.TaskQueryByStatusRequestDTO;
import com.eldorado.task.manager.domain.dto.task.TaskQueryDTO;
import com.eldorado.task.manager.enums.TasksStatusEnum;
import com.eldorado.task.manager.repository.interfaces.task.ITaskCommandRepository;
import com.eldorado.task.manager.repository.interfaces.task.ITaskQueryRepository;
import com.eldorado.task.manager.service.command.interfaces.task.ITaskQueryService;
import org.hibernate.validator.internal.constraintvalidators.bv.AssertFalseValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TaskEldManagerApplicationTests.class)
public class TaskQueryServiceTest {
    @Autowired
    private ITaskQueryRepository iTaskQueryRepository;

    @Autowired
    private ITaskCommandRepository iTaskCommandRepository;

    @BeforeEach
    public void setUp() {



        TaskCommandDTO newTask = TaskCommandDTO.builder()
                                               .title("New Task")
                                               .deadline(LocalDate.now())
                                               .status(TasksStatusEnum.DOING)
                                               .userId(1L)
                                               .build();

        iTaskCommandRepository.createTask(newTask);
    }


    @Test
    public void testGetAllTasks() {
        List<TaskQueryDTO> tasks = this.iTaskQueryRepository.getAllTasks();
        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testFindNoExistentTaskById() {
        Optional<TaskQueryDTO> taskQueryDTO = this.iTaskQueryRepository.getTaskById(5L);
        assertFalse(taskQueryDTO.isPresent());
    }

    @Test
    public void testFindTaskById() {
        Optional<TaskQueryDTO> taskQueryDTO = this.iTaskQueryRepository.getTaskById(1L);
        assertFalse(taskQueryDTO.isPresent());
    }

//    @Override
//    public List<TaskQueryDTO> getTasksByStatus(TaskQueryByStatusRequestDTO filter) {
//        return this.iTaskQueryRepository.getTasksByStatus(filter);
//    }
}
