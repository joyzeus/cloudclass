package com.igeek.admin.dao;

import com.igeek.admin.model.entity.LoginLog;

public interface LoginLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginLog record);
}