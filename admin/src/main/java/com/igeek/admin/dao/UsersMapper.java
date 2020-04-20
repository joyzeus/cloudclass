package com.igeek.admin.dao;

import com.igeek.admin.model.entity.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Long key);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long key);

    int updateByPrimaryKeySelective(Users record);

    Users find(Users users);

    Users findUsers(String account);
}