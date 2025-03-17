package com.eldorado.task.manager.repository.user;

import com.eldorado.task.manager.TaskEldManagerApplicationTests;
import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.domain.user.User;
import com.eldorado.task.manager.repository.interfaces.user.IUserCommandRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TaskEldManagerApplicationTests.class)
@ActiveProfiles("test")
@Transactional
public class UserCommandRepositoryTest {

    @Autowired
    private IUserCommandRepository userCommandRepository;

    @Test
    void testCreateUser() {
        UserCommandDTO userCommandDTO = UserCommandDTO.builder()
                                            .email("williame.rocha10@gmail.com")
                                            .name("Williame Rocha")
                                            .password("123456")
                                            .build();

        User user = this.userCommandRepository.createUser(userCommandDTO);
        assertTrue(user.getId() > 0);
    }
}
