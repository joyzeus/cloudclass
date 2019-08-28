package com.jay.book.admin.module.user.entity.po;

import lombok.Data;

import java.util.Date;

@Data
public class Users {
    private Integer tableId;

    private String account;

    private String password;

    private String mobile;

    private String email;

    private Integer userId;

    private Integer sex;

    private String icon;

    private Date createTime;

    private Date updateTime;
}