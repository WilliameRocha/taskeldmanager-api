package com.eldorado.task.manager.service.command.authentication;

import com.eldorado.task.manager.repository.interfaces.authentication.IAuthenticationQueryRepository;
import com.eldorado.task.manager.service.command.interfaces.authentication.IAuthenticationQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationQueryService implements IAuthenticationQueryService {

    private final IAuthenticationQueryRepository iAuthenticationQueryRepository;

    @Autowired
    public AuthenticationQueryService(IAuthenticationQueryRepository iAuthenticationQueryRepository) {
        this.iAuthenticationQueryRepository = iAuthenticationQueryRepository;
    }
    @Override
    public UserDetails loadUserByEmail(String email) {
        return this.iAuthenticationQueryRepository.loadUserByEmail(email);
    }
}
