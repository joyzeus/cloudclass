package com.igeek.admin.dao;

import com.igeek.admin.model.entity.ExceptionLog;

public interface ExceptionLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExceptionLog record);

    int insertSelective(ExceptionLog record);

    ExceptionLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExceptionLog record);

    int updateByPrimaryKeyWithBLOBs(ExceptionLog record);

    int updateByPrimaryKey(ExceptionLog record);
}