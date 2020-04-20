package com.igeek.admin.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouxu
 * @date 2002/04/16
 * @email 1419982188@qq.com
 */
@Data
public class RolePermissionRelation implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;
}