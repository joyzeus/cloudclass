package com.igeek.admin.dao;

import com.igeek.admin.model.entity.WebLog;

public interface WebLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebLog record);

    int insertSelective(WebLog record);

    WebLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebLog record);

    int updateByPrimaryKey(WebLog record);
}