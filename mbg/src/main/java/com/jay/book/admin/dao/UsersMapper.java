package com.jay.book.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users find(Users record);

    List<Users> list(Users record);

    Page<Users> pageList(Users record);
}