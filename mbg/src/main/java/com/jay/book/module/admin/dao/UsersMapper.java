package com.jay.book.module.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.module.admin.entity.Users;
import java.util.List;

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