package com.jay.book.admin.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsersVo implements Serializable {

    Long code;
    String message;
    Integer userId;
    String accout;
    String token;
}


