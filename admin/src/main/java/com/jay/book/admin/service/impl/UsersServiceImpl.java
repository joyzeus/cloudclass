package com.jay.book.admin.service.impl;

import com.jay.book.admin.service.base.UsersService;
import com.jay.book.admin.dao.UsersMapper;
import com.jay.book.admin.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersMapper usersMapper;

    @Autowired(required = false)
    public UsersServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public Users selectByAccount(String account) {
        return usersMapper.find(Users.Builder.anUsers().withAccount(account).build());
    }

    @Override
    public Integer save(Users user) {
        Users select = usersMapper.find(Users.Builder.anUsers().withAccount(user.getAccount()).build());
        Users anOther = usersMapper.find(Users.Builder.anUsers().withMobile(user.getMobile()).build());
        if (select == null && anOther == null) {
            return usersMapper.insertSelective(user);
        } else {
            return 0;
        }
    }

    @Override
    public Users selectByUserId(Integer userId) {
        return usersMapper.find(Users.Builder.anUsers().withUserId(userId).build());
    }
}
