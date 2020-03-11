package com.igeek.admin.dao;

import com.igeek.admin.entity.Users;
import com.igeek.admin.entity.UsersKey;

public interface UsersMapper {
    int deleteByPrimaryKey(UsersKey key);

    int insertSelective(Users record);

    Users selectByPrimaryKey(UsersKey key);

    int updateByPrimaryKeySelective(Users record);

    Users find(Users users);
}