package com.jay.book.admin.service.base;

import com.jay.book.module.admin.entity.ExceptionLog;

import java.util.List;

public interface ExceptionLogService {
    Integer insertSelective(ExceptionLog log);

    List selectExceptionList();
}
