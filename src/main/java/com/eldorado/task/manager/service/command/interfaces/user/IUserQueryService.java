package com.eldorado.task.manager.service.command.interfaces.user;

import com.eldorado.task.manager.domain.dto.user.UserQueryDTO;

import java.util.List;
import java.util.Optional;

public interface IUserQueryService {
    List<UserQueryDTO> getAllUsers();
    Optional<UserQueryDTO> getUserById(Long id);
    Optional<UserQueryDTO> getUserByEmail(String email);
}
