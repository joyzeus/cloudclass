package com.jay.book.admin.module.user.dao;

import com.jay.book.admin.module.user.entity.CSDNBlog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CSDNBlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(CSDNBlog record);

    CSDNBlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CSDNBlog record);
}