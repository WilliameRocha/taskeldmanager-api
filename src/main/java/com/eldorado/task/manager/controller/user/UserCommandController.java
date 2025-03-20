package com.eldorado.task.manager.controller.user;

import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.domain.user.User;
import com.eldorado.task.manager.service.command.interfaces.user.IUserCommandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserCommandController {

    @Autowired
    private IUserCommandService iUserCommandService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCommandDTO userCommandDTO){
        User user = iUserCommandService.createUser(userCommandDTO);
        return ResponseEntity.ok(user);
    }
}
