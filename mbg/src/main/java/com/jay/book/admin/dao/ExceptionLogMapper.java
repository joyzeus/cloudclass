package com.jay.book.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.entity.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExceptionLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExceptionLog record);

    int insertSelective(ExceptionLog record);

    ExceptionLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExceptionLog record);

    int updateByPrimaryKeyWithBLOBs(ExceptionLog record);

    int updateByPrimaryKey(ExceptionLog record);

    ExceptionLog find(ExceptionLog record);

    List<ExceptionLog> list(ExceptionLog record);

    Page<ExceptionLog> pageList(ExceptionLog record);
}