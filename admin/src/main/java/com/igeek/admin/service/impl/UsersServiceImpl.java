package com.igeek.admin.service.impl;

import com.igeek.admin.dao.UsersMapper;
import com.igeek.admin.model.entity.Users;
import com.igeek.admin.service.base.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired(required = false)
    private UsersMapper usersMapper;

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
        return usersMapper.find(Users.Builder.anUsers().withId(userId).build());
    }
}
