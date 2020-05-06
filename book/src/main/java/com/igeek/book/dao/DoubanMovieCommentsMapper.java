package com.igeek.book.dao;

import com.igeek.book.model.entity.DoubanMovieComments;

public interface DoubanMovieCommentsMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(DoubanMovieComments record);

    int insertSelective(DoubanMovieComments record);

    DoubanMovieComments selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(DoubanMovieComments record);

    int updateByPrimaryKeyWithBLOBs(DoubanMovieComments record);
}