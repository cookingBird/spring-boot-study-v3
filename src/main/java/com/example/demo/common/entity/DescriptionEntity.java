package com.example.demo.common.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class DescriptionEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
