package com.igeek.admin.service.impl;

import com.igeek.admin.dao.LoginLogMapper;
import com.igeek.admin.entity.LoginLog;
import com.igeek.admin.service.base.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired(required = false)
    private LoginLogMapper loginLogMapper;

    @Override
    public Integer insertLog(LoginLog loginLog) {
        return loginLogMapper.insertSelective(loginLog);
    }

    private Integer insertOrReplace(LoginLog loginLog) {
        if (loginLog != null) {
            if (loginLog.getId() == null) {
                return loginLogMapper.insertSelective(loginLog);
            } else {
                return loginLogMapper.updateByPrimaryKeySelective(loginLog);
            }
        } else {
            return 0;
        }
    }
}
