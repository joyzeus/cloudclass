package com.jay.book.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
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