package com.jay.book.admin.module.user.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.module.user.entity.DoubanBook;

import java.util.List;

public interface DoubanBookMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insertSelective(DoubanBook record);

    DoubanBook selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(DoubanBook record);

    DoubanBook find(DoubanBook record);

    List<DoubanBook> list(DoubanBook record);

    Page<DoubanBook> pageList(DoubanBook record);
}