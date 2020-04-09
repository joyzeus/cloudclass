package com.igeek.admin.service.base;

import com.igeek.admin.model.entity.LoginLog;

public interface SysLogService {

    Integer insertLog(LoginLog loginLog);
}
