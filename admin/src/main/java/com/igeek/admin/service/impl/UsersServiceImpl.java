package com.igeek.admin.service.impl;

import com.igeek.admin.dao.UsersMapper;
import com.igeek.admin.model.entity.Users;
import com.igeek.admin.model.entity.UsersDetailEntity;
import com.igeek.admin.service.base.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhoxu
 * @date 2020/04/10
 * @email 1419982188@qq.com
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired(required = false)
    private UsersMapper usersMapper;

    @Override
    public Users findUsers(String account) {
        return usersMapper.findUsers(account);
    }

    @Override
    public Users selectByAccount(String account) {
        Users users = Users.builder().build();
        users.setAccount(account);
        return usersMapper.find(users);
    }

    @Override
    public Integer save(Users user) {
        Users users = Users.builder().build();
        users.setAccount(user.getAccount());
        Users select = usersMapper.find(users);

        users.setAccount(null);
        users.setMobile(user.getMobile());
        Users anOther = usersMapper.find(users);

        if (select == null && anOther == null) {
            return usersMapper.insertSelective(user);
        } else {
            return 0;
        }
    }

    @Override
    public Users selectByUserId(Long userId) {
        Users build = Users.builder().build();
        build.setId(userId);
        return usersMapper.find(build);
    }

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Users users = usersMapper.findUsers(account);
        return new UsersDetailEntity();
    }
}
