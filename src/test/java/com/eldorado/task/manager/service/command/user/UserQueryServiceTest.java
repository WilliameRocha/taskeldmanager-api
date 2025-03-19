package com.eldorado.task.manager.service.command.user;

import com.eldorado.task.manager.TaskEldManagerApplicationTests;
import com.eldorado.task.manager.domain.dto.user.UserQueryDTO;
import com.eldorado.task.manager.repository.interfaces.user.IUserQueryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = TaskEldManagerApplicationTests.class)
@ActiveProfiles("test")
@Transactional
public class UserQueryServiceTest {

    @Autowired
    private IUserQueryRepository iUserRepository;

    @Test
    public void testGetAllUsers() {
        List<UserQueryDTO> users = this.iUserRepository.getAllUsers();
        assertFalse(users.isEmpty());
    }

    @Test
    public void testFindExistentUserById() {

        Optional<UserQueryDTO> userQueryDTO = this.iUserRepository.getUserById(1L);

        assertNotNull(userQueryDTO);
    }

    @Test
    public void testFindNonExistentUserById() {

        Optional<UserQueryDTO> userQueryDTO = this.iUserRepository.getUserById(50L);

        assertTrue(userQueryDTO.isEmpty());
    }
}
