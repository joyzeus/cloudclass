package com.jay.book.admin.dao;

import com.jay.book.admin.entity.model.LoginLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginLogMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(LoginLog record);
}