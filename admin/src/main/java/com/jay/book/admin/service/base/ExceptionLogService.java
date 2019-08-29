package com.jay.book.admin.service.base;

import com.jay.book.admin.entity.model.ExceptionLog;

import java.util.List;

public interface ExceptionLogService {
    Integer insertSelective(ExceptionLog log);

    List selectExceptionList();
}
