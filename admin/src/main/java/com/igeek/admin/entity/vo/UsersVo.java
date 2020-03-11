package com.igeek.admin.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
@Data
public class UsersVo implements Serializable {

    Long code;
    String message;
    Integer userId;
    String accout;
    String token;
}


