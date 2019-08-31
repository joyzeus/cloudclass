package com.jay.book.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.entity.PermissionGroupRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
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