package com.igeek.admin.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolePermissionRelation implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;
}