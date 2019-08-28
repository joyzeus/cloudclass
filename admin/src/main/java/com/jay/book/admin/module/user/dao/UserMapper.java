package com.jay.book.admin.module.user.dao;

import com.jay.book.admin.module.user.entity.po.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(Users record);

    Users selectByAccountOrMobile(String acount);

    Users selectByUserId(Integer userId);
}