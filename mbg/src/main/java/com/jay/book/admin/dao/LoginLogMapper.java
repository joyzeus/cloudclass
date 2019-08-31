package com.jay.book.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginLogMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);

    LoginLog find(LoginLog record);

    List<LoginLog> list(LoginLog record);

    Page<LoginLog> pageList(LoginLog record);
}