package com.jay.book.module.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.module.admin.entity.Permission;
import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    Permission find(Permission record);

    List<Permission> list(Permission record);

    Page<Permission> pageList(Permission record);
}