package com.jay.book.module.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.module.admin.entity.LoginLog;
import java.util.List;

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