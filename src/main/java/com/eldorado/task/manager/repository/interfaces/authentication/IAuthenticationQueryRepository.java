package com.eldorado.task.manager.repository.interfaces.authentication;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface IAuthenticationQueryRepository {
    UserDetails loadUserByEmail(String email);
}
