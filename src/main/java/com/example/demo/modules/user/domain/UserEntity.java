package com.example.demo.modules.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.common.entity.BaseDataEntity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Entity
@Accessors(chain = true)
@Table(name = "dt_user")
@TableName("dt_user")
public class UserEntity extends BaseDataEntity {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone;

    private String email;

    private String name;

    private String account;

    private  String password;

    private String Roles;

    private String status;

    private String avatar;

    private String gender;

    private String birthday;

}
