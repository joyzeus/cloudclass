package com.jay.book.admin.service.impl;

import com.jay.book.admin.service.base.SysLogService;
import com.jay.book.admin.dao.LoginLogMapper;
import com.jay.book.admin.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService {

    private final LoginLogMapper loginLogMapper;

    @Autowired(required = false)
    public SysLogServiceImpl(LoginLogMapper loginLogMapper) {
        this.loginLogMapper = loginLogMapper;
    }

    @Override
    public Integer insertLog(LoginLog loginLog) {
        return loginLogMapper.insertSelective(loginLog);
    }

    private Integer insertOrReplace(LoginLog loginLog) {
        if (loginLog != null) {
            if (loginLog.getTableId() == null) {
                return loginLogMapper.insertSelective(loginLog);
            } else {
                return loginLogMapper.updateByPrimaryKeySelective(loginLog);
            }
        } else {
            return 0;
        }
    }
}
