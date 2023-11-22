package com.example.demo.common.entity;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class LogicDelEntity {
    @ApiModelProperty("是否删除")
    Integer isDelete = null;

}
