package com.jay.book.admin.module.user.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.module.user.entity.DoubanMovie;

import java.util.List;

public interface DoubanMovieMapper {
    int deleteByPrimaryKey(Integer movieId);

    int insertSelective(DoubanMovie record);

    DoubanMovie selectByPrimaryKey(Integer movieId);

    int updateByPrimaryKeySelective(DoubanMovie record);

    DoubanMovie find(DoubanMovie record);

    List<DoubanMovie> list(DoubanMovie record);

    Page<DoubanMovie> pageList(DoubanMovie record);
}