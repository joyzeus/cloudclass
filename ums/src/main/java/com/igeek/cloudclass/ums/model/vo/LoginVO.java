package com.igeek.cloudclass.ums.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/5/19
 */
@Data
public class LoginVO implements Serializable {
    private String username;
    private String password;
    private String uuid;
    private String code;
}
