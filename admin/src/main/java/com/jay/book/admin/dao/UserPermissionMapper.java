package com.jay.book.admin.dao;

import com.jay.book.admin.entity.UserPermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPermissionMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    UserPermission selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
}