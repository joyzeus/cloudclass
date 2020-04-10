package com.igeek.admin.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/04/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(toBuilder = true)
public class Users extends UsersKey {

    private Long id;

    private String account;

    private String mobile;

    private String email;

    private String password;

    private String nickname;

    private String sex;

    private String headImage;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;

    private Integer loginCount;

    private Boolean locked;

    private Boolean login;
}