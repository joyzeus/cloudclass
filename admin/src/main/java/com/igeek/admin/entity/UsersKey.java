package com.igeek.admin.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsersKey implements Serializable {
    private Integer id;

    private String account;

    private String mobile;
}