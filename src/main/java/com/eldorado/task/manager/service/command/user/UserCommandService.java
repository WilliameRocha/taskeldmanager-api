package com.eldorado.task.manager.service.command.user;

import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.domain.user.User;
import com.eldorado.task.manager.repository.interfaces.user.IUserCommandRepository;
import com.eldorado.task.manager.service.command.interfaces.user.IUserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandService implements IUserCommandService {

    @Autowired
    private IUserCommandRepository iUserCommandRepository;

    @Override
    public User createUser(UserCommandDTO userCommandDTO) {
        return this.iUserCommandRepository.createUser(userCommandDTO);
    }
}
