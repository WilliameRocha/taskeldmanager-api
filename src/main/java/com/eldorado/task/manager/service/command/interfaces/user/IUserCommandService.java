package com.eldorado.task.manager.service.command.interfaces.user;

import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.domain.user.User;

public interface IUserCommandService {
    User createUser(UserCommandDTO userCommandDTO);
}
