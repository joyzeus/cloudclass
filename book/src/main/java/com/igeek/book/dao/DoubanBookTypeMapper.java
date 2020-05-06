package com.igeek.book.dao;

import com.igeek.book.model.entity.DoubanBookType;

import java.util.List;

public interface DoubanBookTypeMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(DoubanBookType record);

    int insertSelective(DoubanBookType record);

    DoubanBookType selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(DoubanBookType record);

    int updateByPrimaryKey(DoubanBookType record);

    List<DoubanBookType> find(DoubanBookType record);

    DoubanBookType selectByType(String name);
}