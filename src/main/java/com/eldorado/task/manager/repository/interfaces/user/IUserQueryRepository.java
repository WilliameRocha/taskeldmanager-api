package com.eldorado.task.manager.repository.interfaces.user;

import com.eldorado.task.manager.domain.dto.user.UserQueryDTO;

import java.util.List;
import java.util.Optional;


public interface IUserQueryRepository {
    List<UserQueryDTO> getAllUsers();
    Optional<UserQueryDTO> getUserById(Long id);
    Optional<UserQueryDTO> getUserByEmail(String email);
}
