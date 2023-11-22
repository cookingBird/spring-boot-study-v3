package com.example.demo.modules.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.modules.user.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    default UserEntity existUser(String username, String password) throws Exception {
        UserEntity usr = this.selectOne(new QueryWrapper<UserEntity>()
                .eq("name", username)
                .eq("password", password)
        );
        if (usr == null) {
            throw new Exception("user not found");
        }
        return usr;
    }
}
