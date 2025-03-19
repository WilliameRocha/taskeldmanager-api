package com.eldorado.task.manager.service.command.user;

import com.eldorado.task.manager.TaskEldManagerApplicationTests;
import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.domain.user.User;
import com.eldorado.task.manager.service.command.interfaces.user.IUserCommandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TaskEldManagerApplicationTests.class)
@ActiveProfiles("test")
@Transactional
public class UserCommandServiceTest {

    @Autowired
    private IUserCommandService iUserCommandService;

    @Test
    void testCreateUser() {
        UserCommandDTO userCommandDTO = UserCommandDTO.builder()
                                                       .email("williame.rocha10@gmail.com")
                                                       .name("Williame Rocha")
                                                       .password("123456")
                                                       .build();

        User user = this.iUserCommandService.createUser(userCommandDTO);
        assertTrue(user.getId() > 0);
    }
}
