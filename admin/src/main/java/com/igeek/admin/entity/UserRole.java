package com.igeek.admin.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer roleId;
}