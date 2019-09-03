package com.jay.book.admin.service.impl;

import com.jay.book.admin.dao.WebLogMapper;
import com.jay.book.admin.entity.WebLog;
import com.jay.book.admin.service.base.WebLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebLogServiceImpl implements WebLogService {

    private final WebLogMapper webLogMapper;

    @Autowired(required = false)
    public WebLogServiceImpl(WebLogMapper webLogMapper) {
        this.webLogMapper = webLogMapper;
    }

    @Override
    public Integer insert(WebLog webLog) {
        return webLogMapper.insertSelective(webLog);
    }
}
