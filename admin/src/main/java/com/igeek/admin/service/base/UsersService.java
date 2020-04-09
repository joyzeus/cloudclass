package com.igeek.admin.service.base;

import com.igeek.admin.model.entity.Users;

public interface UsersService {

    Users selectByAccount(String account);

    Integer save(Users user);

    Users selectByUserId(Integer userId);
}
