package com.igeek.spider.dao;

import com.igeek.spider.model.entity.DoubanMovie;

public interface DoubanMovieMapper {
    int deleteByPrimaryKey(Integer movieId);

    int insert(DoubanMovie record);

    int insertSelective(DoubanMovie record);

    DoubanMovie selectByPrimaryKey(Integer movieId);

    int updateByPrimaryKeySelective(DoubanMovie record);

    int updateByPrimaryKeyWithBLOBs(DoubanMovie record);

    int updateByPrimaryKey(DoubanMovie record);
}