package com.eldorado.task.manager.service.command.user;

import com.eldorado.task.manager.domain.dto.user.UserQueryDTO;
import com.eldorado.task.manager.repository.interfaces.user.IUserQueryRepository;
import com.eldorado.task.manager.service.command.interfaces.user.IUserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserQueryService implements IUserQueryService {

    @Autowired
    private IUserQueryRepository iUserRepository;

    @Override
    public List<UserQueryDTO> getAllUsers() {
        return iUserRepository.getAllUsers();
    }

    @Override
    public Optional<UserQueryDTO> getUserById(Long id) {
        Objects.requireNonNull(id, "The id must not be null");
        if( id <= 0){
            throw new IllegalArgumentException("The id must be greater than 0");
        }
        return this.iUserRepository.getUserById(id);
    }

    @Override
    public Optional<UserQueryDTO> getUserByEmail(String email) {
        Objects.requireNonNull(email, "The email must not be null");
        if (email.isBlank()) {
            throw new IllegalArgumentException("The email must not be blank");
        }
        return this.iUserRepository.getUserByEmail(email);
    }
}
