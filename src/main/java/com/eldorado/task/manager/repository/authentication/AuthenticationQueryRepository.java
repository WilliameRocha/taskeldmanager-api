package com.eldorado.task.manager.repository.authentication;

import com.eldorado.task.manager.domain.user.User;
import com.eldorado.task.manager.repository.interfaces.authentication.IAuthenticationQueryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Repository
public class AuthenticationQueryRepository implements IAuthenticationQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserDetails loadUserByEmail(String email) {
        com.eldorado.task.manager.domain.user.User user
                = this.entityManager.createQuery("SELECT user FROM User user WHERE user.email = :email", User.class)
                                    .setParameter("email", email)
                                    .getSingleResult();

        if(user != null) {
            return org.springframework.security.core.userdetails.User
                            .withUsername(user.getEmail())
                            .password(user.getPassword())
                            .roles("USER")
                            .build();
        }
        throw new UsernameNotFoundException("User not found");
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        com.eldorado.task.manager.domain.user.User user
//                = this.entityManager.createQuery("SELECT user FROM User user WHERE user.email = :email", User.class)
//                .setParameter("email", username)
//                .getSingleResult();
//
//        UserDetails userDetails = null;
//        if(user != null) {
//            userDetails = org.springframework.security.core.userdetails.User
//                    .withUsername(user.getEmail())
//                    .password(user.getPassword())
//                    .roles("USER")
//                    .build();
//            return userDetails;
//        }
//        throw new UsernameNotFoundException("User not found");
//    }
}
