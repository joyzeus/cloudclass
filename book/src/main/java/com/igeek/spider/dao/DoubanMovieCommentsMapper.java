package com.igeek.spider.dao;

import com.igeek.spider.model.entity.DoubanMovieComments;

public interface DoubanMovieCommentsMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(DoubanMovieComments record);

    int insertSelective(DoubanMovieComments record);

    DoubanMovieComments selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(DoubanMovieComments record);

    int updateByPrimaryKeyWithBLOBs(DoubanMovieComments record);
}