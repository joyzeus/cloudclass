package com.jay.book.admin.dao;

import com.jay.book.admin.entity.PermissionGroupRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionGroupRelationMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(PermissionGroupRelation record);

    int insertSelective(PermissionGroupRelation record);

    PermissionGroupRelation selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(PermissionGroupRelation record);

    int updateByPrimaryKey(PermissionGroupRelation record);
}