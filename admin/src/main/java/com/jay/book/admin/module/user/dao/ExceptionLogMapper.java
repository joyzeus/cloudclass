package com.jay.book.admin.module.user.dao;

import com.jay.book.admin.module.user.entity.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExceptionLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ExceptionLog record);

    ExceptionLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExceptionLog record);
}