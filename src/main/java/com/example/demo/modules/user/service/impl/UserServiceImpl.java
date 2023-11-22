package com.example.demo.modules.user.service.impl;

import com.example.demo.common.factory.Response;
import com.example.demo.modules.user.domain.UserEntity;
import com.example.demo.modules.user.mapper.UserMapper;
import com.example.demo.modules.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    UserMapper userMapper;

    @Override
    public void registry(UserEntity usr) {
        userMapper.insert(usr);

    }

    @Override
    public UserEntity login(String username,String password) throws Exception {
        // todo 查询数据库是否存在该用户
        UserEntity usr = userMapper.existUser(username,password);
        return usr;
    }

    @Override
    public void logout() {

    }
}
