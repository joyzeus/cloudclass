package com.jay.book.admin.service.impl;

import com.jay.book.admin.dao.UserMapper;
import com.jay.book.admin.entity.model.Users;
import com.jay.book.admin.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired(required = false)
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Users selectByAccount(String account) {
        return userMapper.selectByAccountOrMobile(account);
    }

    @Override
    public Integer save(Users user) {
        Users select = userMapper.selectByAccountOrMobile(user.getMobile());
        if (select == null) {
            return userMapper.insertSelective(user);
        } else {
            return 0;
        }
    }

    @Override
    public Users selectByUserId(Integer userId) {
        return userMapper.selectByUserId(userId);
    }
}
