package com.jay.book.module.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.module.admin.entity.PermissionGroupRelation;
import java.util.List;

public interface PermissionGroupRelationMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(PermissionGroupRelation record);

    int insertSelective(PermissionGroupRelation record);

    PermissionGroupRelation selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(PermissionGroupRelation record);

    int updateByPrimaryKey(PermissionGroupRelation record);

    PermissionGroupRelation find(PermissionGroupRelation record);

    List<PermissionGroupRelation> list(PermissionGroupRelation record);

    Page<PermissionGroupRelation> pageList(PermissionGroupRelation record);
}