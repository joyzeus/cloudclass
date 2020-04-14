package com.igeek.admin.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
@Data
public class UsersVo implements Serializable {

    Integer code;
    String message;
    String accout;
    String token;
}


