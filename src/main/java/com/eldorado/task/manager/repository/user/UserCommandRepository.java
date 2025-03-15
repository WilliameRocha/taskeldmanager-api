package com.eldorado.task.manager.repository.user;

import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.domain.user.User;
import com.eldorado.task.manager.repository.interfaces.user.IUserCommandRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserCommandRepository implements IUserCommandRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User createUser(UserCommandDTO userCommandDTO) {
        User user = User.builder()
                        .name(userCommandDTO.getName())
                        .email(userCommandDTO.getEmail())
                        .password(userCommandDTO.getPassword())
                        .build();
        this.entityManager.persist(user);
        return user;
    }
}
