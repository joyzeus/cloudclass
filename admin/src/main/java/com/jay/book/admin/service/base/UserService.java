package com.jay.book.admin.service.base;

import com.jay.book.admin.entity.model.Users;

public interface UserService {

    Users selectByAccount(String account);

    Integer save(Users user);

    Users selectByUserId(Integer userId);
}
