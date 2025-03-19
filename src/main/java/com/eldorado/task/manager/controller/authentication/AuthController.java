package com.eldorado.task.manager.controller.authentication;

import com.eldorado.task.manager.domain.dto.user.UserAuthDTO;
import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.service.command.interfaces.user.IUserCommandService;
import com.eldorado.task.manager.util.JwtGenerator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserCommandService iUserCommandService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserAuthDTO user) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        String token = this.jwtGenerator.generateToken(user.getEmail());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@Valid @RequestBody UserCommandDTO user) {
        this.iUserCommandService.createUser(user);
        return ResponseEntity.ok(true);
    }
}
