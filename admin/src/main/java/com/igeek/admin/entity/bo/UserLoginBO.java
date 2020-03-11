package com.igeek.admin.entity.bo;

import lombok.Data;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
@Data
public class UserLoginBO {

    private String username;
    private String password;
    private String uuid;
    private String verificationCode;
}
