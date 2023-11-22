package com.example.demo.modules.user.service;

import com.example.demo.common.factory.Response;
import com.example.demo.modules.user.domain.UserEntity;

public interface IUserService {
    void registry(UserEntity usr);

    UserEntity login(String username, String password) throws Exception;

    void logout();

}
