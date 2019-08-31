package com.jay.book.book.dao;

import com.github.pagehelper.Page;
import com.jay.book.book.entity.DoubanBookType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoubanBookTypeMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insertSelective(DoubanBookType record);

    DoubanBookType selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(DoubanBookType record);

    DoubanBookType find(DoubanBookType record);

    List<DoubanBookType> list(DoubanBookType record);

    Page<DoubanBookType> pageList(DoubanBookType record);
}