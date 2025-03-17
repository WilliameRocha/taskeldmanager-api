package com.eldorado.task.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest()
@ActiveProfiles("test")
@ComponentScan(basePackages = {"com"})
public class TaskEldManagerApplicationTests {

//    @Test
//    void contextLoads() {
//    }
}
