package com.example.demo.common.entity;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public class BaseDataEntity extends MutationInfoEntity  implements Serializable { }
