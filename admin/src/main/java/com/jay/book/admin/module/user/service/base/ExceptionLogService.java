package com.jay.book.admin.module.user.service.base;

import com.jay.book.admin.module.user.entity.ExceptionLog;

import java.util.List;

public interface ExceptionLogService {
    Integer insertSelective(ExceptionLog log);

    List selectExceptionList();
}
