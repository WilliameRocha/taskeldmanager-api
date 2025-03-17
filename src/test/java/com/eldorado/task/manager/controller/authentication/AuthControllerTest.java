package com.eldorado.task.manager.controller.authentication;

import com.eldorado.task.manager.TaskEldManagerApplicationTests;
import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.domain.dto.user.UserQueryDTO;
import com.eldorado.task.manager.service.command.interfaces.user.IUserCommandService;
import com.eldorado.task.manager.service.command.interfaces.user.IUserQueryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TaskEldManagerApplicationTests.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserCommandService iUserCommandService;

    @Autowired
    private IUserQueryService iUserQueryService;

    private String email = "rocha@gmail.com";

    private String password = "123456";

    @BeforeEach
    public void setUp() {

        Optional<UserQueryDTO> user = this.iUserQueryService.getUserByEmail(email);

        if(user.isEmpty()) {

            UserCommandDTO userCommandDTO = UserCommandDTO.builder()
                    .name("Williame Rocha")
                    .email(email)
                    .password(password)
                    .build();
            this.iUserCommandService.createUser(userCommandDTO);

        }
    }

    @Test
    void testLoginSuccessfully() throws Exception{

        this.mockMvc.perform(post("/auth/login")
                        .param("email", email)
                        .param("password", password)
                        .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    @Test
    void testLoginUnsuccessfully() throws Exception{
        this.mockMvc.perform(post("/auth/login")
                        .param("email", email)
                        .param("password", "xxxx")
                        .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isForbidden());
    }
}
