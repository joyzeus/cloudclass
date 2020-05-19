package com.igeek.cloudclass.ums.mapper;

import com.igeek.cloudclass.ums.model.entity.UserPermission;

public interface UserPermissionMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    UserPermission selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
}