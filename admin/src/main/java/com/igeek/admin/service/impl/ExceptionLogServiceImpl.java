package com.igeek.admin.service.impl;

import com.igeek.admin.dao.ExceptionLogMapper;
import com.igeek.admin.entity.ExceptionLog;
import com.igeek.admin.service.base.ExceptionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {

    @Autowired(required = false)
    private ExceptionLogMapper exceptionLogMapper;

    @Override
    public Integer insertSelective(ExceptionLog log) {
        return exceptionLogMapper.insertSelective(log);
    }

    @Override
    public List<ExceptionLog> selectExceptionList() {
        return null;
    }
}
