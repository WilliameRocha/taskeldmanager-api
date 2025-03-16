package com.eldorado.task.manager.service.command.authentication;

import com.eldorado.task.manager.repository.interfaces.authentication.IAuthenticationQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailImpService implements UserDetailsService/*, IAuthenticationQueryService*/ {

    private final IAuthenticationQueryRepository iAuthenticationQueryRepository;

    @Autowired
    public UserDetailImpService(IAuthenticationQueryRepository iAuthenticationQueryRepository) {
        this.iAuthenticationQueryRepository = iAuthenticationQueryRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = this.iAuthenticationQueryRepository.loadUserByEmail(username);
        if(userDetails == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return userDetails;
    }

//    @Override
//    public UserDetails loadUserByEmail(String email) {
//        return this.iAuthenticationQueryRepository.loadUserByEmail(email);
//    }
}
