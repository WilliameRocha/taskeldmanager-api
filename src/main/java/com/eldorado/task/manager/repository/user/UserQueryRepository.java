package com.eldorado.task.manager.repository.user;

import com.eldorado.task.manager.domain.dto.user.UserQueryDTO;
import com.eldorado.task.manager.domain.user.User;
import com.eldorado.task.manager.repository.interfaces.user.IUserQueryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserQueryRepository implements IUserQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserQueryDTO> getAllUsers() {
        return this.entityManager
                   .createQuery("SELECT user FROM User user", User.class)
                   .getResultList()
                   .stream()
                   .map(user -> UserQueryDTO.builder()
                                                  .id(user.getId())
                                                  .firstName(user.getFirstName())
                                                  .lastName(user.getLastName())
                                                  .email(user.getEmail())
                                                  .build())
                  .collect(Collectors.toList());
    }

    @Override
    public Optional<UserQueryDTO> getUserById(Long id) {
        User user = this.entityManager.find(User.class, id);
        UserQueryDTO userQueryDTO = null;
        if(user != null) {
            userQueryDTO = UserQueryDTO.builder()
                                       .id(user.getId())
                                       .firstName(user.getFirstName())
                                       .lastName(user.getLastName())
                                       .email(user.getEmail())
                                       .build();
        }
        return Optional.ofNullable(userQueryDTO);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<UserQueryDTO> getUserByEmail(String email) {
        return this.entityManager
                   .createQuery("SELECT user FROM User user WHERE user.email = :email", User.class)
                   .setParameter("email", email)
                   .getResultList()
                   .stream()
                   .findFirst()
                   .map(user -> UserQueryDTO.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .build());
    }
}
