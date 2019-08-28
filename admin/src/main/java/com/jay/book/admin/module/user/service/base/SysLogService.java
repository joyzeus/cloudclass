package com.jay.book.admin.module.user.service.base;

import com.jay.book.admin.module.user.entity.po.Users;

import javax.servlet.http.HttpServletRequest;

public interface SysLogService {

    Integer insertLog(HttpServletRequest request, Users users, String message);
}
