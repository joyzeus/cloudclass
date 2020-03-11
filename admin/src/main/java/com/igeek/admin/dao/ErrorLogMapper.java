package com.igeek.admin.dao;

import com.igeek.admin.entity.ErrorLog;

public interface ErrorLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ErrorLog record);

    int insertSelective(ErrorLog record);

    ErrorLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ErrorLog record);

    int updateByPrimaryKeyWithBLOBs(ErrorLog record);

    int updateByPrimaryKey(ErrorLog record);
}