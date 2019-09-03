package com.jay.book.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.entity.WebLog;
import java.util.List;

public interface WebLogMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(WebLog record);

    int insertSelective(WebLog record);

    WebLog selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(WebLog record);

    int updateByPrimaryKey(WebLog record);

    WebLog find(WebLog record);

    List<WebLog> list(WebLog record);

    Page<WebLog> pageList(WebLog record);
}