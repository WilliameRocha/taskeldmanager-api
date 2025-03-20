package com.eldorado.task.manager.taskeldmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= "com")
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.eldorado.task.manager.domain.*"})
@ComponentScan(basePackages = {"com.eldorado"})
@EnableJpaRepositories(basePackages = {"com.eldorado.task.manager.repository.*"})
public class TaskEldManagerApplication  {
    public static void main(String[] args) {
        SpringApplication.run(TaskEldManagerApplication.class, args);
    }
}
