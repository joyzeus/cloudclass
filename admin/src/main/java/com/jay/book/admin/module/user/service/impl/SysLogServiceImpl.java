package com.jay.book.admin.module.user.service.impl;

import com.jay.book.admin.module.user.entity.po.Users;
import com.jay.book.admin.util.UserAgentUtils;
import com.jay.book.admin.module.user.dao.LoginLogMapper;
import com.jay.book.admin.module.user.entity.LoginLog;
import com.jay.book.admin.module.user.service.base.SysLogService;
import com.jay.book.admin.util.IPUtil;
import eu.bitwalker.useragentutils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class SysLogServiceImpl implements SysLogService {

    private final LoginLogMapper loginLogMapper;

    @Autowired(required = false)
    public SysLogServiceImpl(LoginLogMapper loginLogMapper) {
        this.loginLogMapper = loginLogMapper;
    }

    @Override
    public Integer insertLog(HttpServletRequest request, Users users, String message) {
        try {
            String ipAddr = IPUtil.getIpAddr(request);
            String ipLocation = IPUtil.getIPLocation(ipAddr);

            UserAgent userAgent = UserAgentUtils.getUserAgent(request);
            Version browserVersion = userAgent.getBrowserVersion();
            return insertOrReplace(LoginLog.LoginLogBuilder.aLoginLog()
                    .withUserId(users.getUserId())
                    .withCreateTime(new Date())
                    .withIp(ipAddr)
                    .withLocation(ipLocation)
                    .withClientType(userAgent.getOperatingSystem().getName())
                    .withKarnelVersion(browserVersion == null ? "" : browserVersion.getVersion())
                    .withClientAgent(userAgent.getBrowser().getName())
                    .withUseragent(request.getHeader("User-Agent"))
                    .withMessage(message)
                    .build());
        } finally {
            return 0;
        }
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

