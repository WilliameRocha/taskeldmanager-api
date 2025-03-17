package com.eldorado.task.manager.controller.user;

import com.eldorado.task.manager.TaskEldManagerApplicationTests;
import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.domain.dto.user.UserQueryDTO;
import com.eldorado.task.manager.domain.user.User;
import com.eldorado.task.manager.service.command.interfaces.user.IUserCommandService;
import com.eldorado.task.manager.service.command.interfaces.user.IUserQueryService;
import com.eldorado.task.manager.taskeldmanager.TaskEldManagerApplication;
import com.eldorado.task.manager.util.JwtGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TaskEldManagerApplicationTests.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserCommandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private IUserCommandService iUserCommandService;

    @Autowired
    private IUserQueryService iUserQueryService;

    private String token;

    @BeforeEach
    public void setUp() {

        String email = "will@gmail.com";

        Optional<UserQueryDTO> user = this.iUserQueryService.getUserByEmail(email);

        if(user.isEmpty()) {

            UserCommandDTO userCommandDTO = UserCommandDTO.builder()
                    .name("Williame Rocha")
                    .email(email)
                    .password("123456")
                    .build();
            this.iUserCommandService.createUser(userCommandDTO);

        }
        this.token = this.jwtGenerator.generateToken(email);
    }

    @Test
    void testCreateUser() throws Exception{
        String requestBody = "{\n" +
                "    \"email\": \"williame.rocha10@gmail.com\",\n" +
                "    \"name\": \"williame rocha\",\n" +
                "    \"password\": \"123456\"\n" +
                "}";

        this.mockMvc.perform(post("/api/user")
                            .header("Authorization", "Bearer " + this.token)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))
                    .andExpect(status().isOk());
    }
}
