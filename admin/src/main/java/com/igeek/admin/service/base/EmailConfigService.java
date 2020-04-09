package com.igeek.admin.service.base;

import com.igeek.admin.model.entity.EmailConfig;

import java.util.List;

public interface EmailConfigService {

    List<EmailConfig> get(EmailConfig emailConfig);

    Integer insertSelective(EmailConfig emailConfig);

    EmailConfig selectSendEmailAccount();

    List<EmailConfig> selectReceiveEmailAccountWithRedisCache();
}
