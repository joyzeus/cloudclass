package com.jay.book.admin.module.user.service.base;

import com.jay.book.admin.module.user.entity.po.Users;

public interface UserService {

    Users selectByAccount(String account);

    Integer save(Users user);

    Users selectByUserId(Integer userId);
}
