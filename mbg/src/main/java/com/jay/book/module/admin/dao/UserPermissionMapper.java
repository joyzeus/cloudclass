package com.jay.book.module.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.module.admin.entity.UserPermission;
import java.util.List;

public interface UserPermissionMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    UserPermission selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);

    UserPermission find(UserPermission record);

    List<UserPermission> list(UserPermission record);

    Page<UserPermission> pageList(UserPermission record);
}