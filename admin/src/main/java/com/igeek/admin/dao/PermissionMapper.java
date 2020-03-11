package com.igeek.admin.dao;

import com.igeek.admin.entity.Permission;
import com.igeek.admin.entity.vo.UserPermissionVO;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> list(Permission record);
}