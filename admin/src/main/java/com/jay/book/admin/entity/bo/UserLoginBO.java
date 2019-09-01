package com.jay.book.admin.entity.bo;

import lombok.Data;

@Data
public class UserLoginBO {

    private String username;
    private String password;
    private String uuid;
    private String verificationCode;
}
