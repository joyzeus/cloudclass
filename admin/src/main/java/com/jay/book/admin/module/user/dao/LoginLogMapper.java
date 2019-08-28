package com.jay.book.admin.module.user.dao;

import com.jay.book.admin.module.user.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginLogMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(LoginLog record);
}