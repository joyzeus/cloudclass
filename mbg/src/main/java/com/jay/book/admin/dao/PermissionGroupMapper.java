package com.jay.book.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.entity.PermissionGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
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