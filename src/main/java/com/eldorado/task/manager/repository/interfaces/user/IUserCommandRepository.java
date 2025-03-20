package com.eldorado.task.manager.repository.interfaces.user;

import com.eldorado.task.manager.domain.dto.user.UserCommandDTO;
import com.eldorado.task.manager.domain.user.User;


public interface IUserCommandRepository {
    User createUser(UserCommandDTO userCommandDTO);
}
