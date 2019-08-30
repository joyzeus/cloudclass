package com.jay.book.module.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.module.admin.entity.PermissionGroup;
import java.util.List;

public interface PermissionGroupMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(PermissionGroup record);

    int insertSelective(PermissionGroup record);

    PermissionGroup selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(PermissionGroup record);

    int updateByPrimaryKey(PermissionGroup record);

    PermissionGroup find(PermissionGroup record);

    List<PermissionGroup> list(PermissionGroup record);

    Page<PermissionGroup> pageList(PermissionGroup record);
}