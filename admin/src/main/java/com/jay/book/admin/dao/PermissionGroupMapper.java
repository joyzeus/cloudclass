package com.jay.book.admin.dao;

import com.jay.book.admin.entity.PermissionGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionGroupMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(PermissionGroup record);

    int insertSelective(PermissionGroup record);

    PermissionGroup selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(PermissionGroup record);

    int updateByPrimaryKey(PermissionGroup record);
}