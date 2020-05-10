package com.igeek.spider.dao;

import com.igeek.spider.model.entity.DoubanBook;

import java.util.List;

public interface DoubanBookMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(DoubanBook record);

    int insertSelective(DoubanBook record);

    DoubanBook selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(DoubanBook record);

    int updateByPrimaryKey(DoubanBook record);

    List<DoubanBook> find(DoubanBook build);

    Integer deleteByBookName(String bookName);
}