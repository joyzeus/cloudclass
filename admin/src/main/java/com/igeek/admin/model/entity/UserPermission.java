package com.igeek.admin.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserPermission implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer permissionId;

    private Date expiredTime;
}