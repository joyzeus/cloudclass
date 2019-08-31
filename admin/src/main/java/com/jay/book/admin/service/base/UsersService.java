package com.jay.book.admin.service.base;

import com.jay.book.admin.entity.Users;

public interface UsersService {

    Users selectByAccount(String account);

    Integer save(Users user);

    Users selectByUserId(Integer userId);
}
