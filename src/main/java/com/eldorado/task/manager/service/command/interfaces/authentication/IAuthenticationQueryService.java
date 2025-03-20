package com.eldorado.task.manager.service.command.interfaces.authentication;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface IAuthenticationQueryService {
    UserDetails loadUserByEmail(String email);
}
