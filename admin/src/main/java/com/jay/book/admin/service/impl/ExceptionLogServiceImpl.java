package com.jay.book.admin.service.impl;

import com.jay.book.admin.service.base.ExceptionLogService;
import com.jay.book.admin.dao.ExceptionLogMapper;
import com.jay.book.admin.entity.ExceptionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {

    private final ExceptionLogMapper exceptionLogMapper;

    @Autowired(required = false)
    public ExceptionLogServiceImpl(ExceptionLogMapper exceptionLogMapper) {
        this.exceptionLogMapper = exceptionLogMapper;
    }

    @Override
    public Integer insertSelective(ExceptionLog log) {
        return exceptionLogMapper.insertSelective(log);
    }

    @Override
    public List selectExceptionList() {
        return null;
    }
}
