package com.igeek.admin.service.base;

import com.igeek.admin.entity.ExceptionLog;

import java.util.List;

public interface ExceptionLogService {
    Integer insertSelective(ExceptionLog log);

    List<ExceptionLog> selectExceptionList();
}
