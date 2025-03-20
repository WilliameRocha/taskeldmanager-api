package com.eldorado.task.manager.controller.user;

import com.eldorado.task.manager.domain.dto.user.UserQueryDTO;
import com.eldorado.task.manager.service.command.interfaces.user.IUserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserQueryController {

    @Autowired
    private IUserQueryService iUserQueryService;

    @GetMapping("/all")
    public ResponseEntity<List<UserQueryDTO>> getAllUsers() {
        return ResponseEntity.ok(this.iUserQueryService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserQueryDTO> getUserById(@PathVariable Long id){
        return this.iUserQueryService.getUserById(id)
                   .map(user -> ResponseEntity.ok().body(user))
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserQueryDTO> getUserByEmail(@PathVariable String email){
        return  this.iUserQueryService.getUserByEmail(email)
                                      .map(user -> ResponseEntity.ok().body(user))
                                      .orElseGet(ResponseEntity.notFound()::build);
    }
}
