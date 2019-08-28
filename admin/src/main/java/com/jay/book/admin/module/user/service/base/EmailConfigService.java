package com.jay.book.admin.module.user.service.base;

import com.jay.book.admin.module.user.entity.EmailConfig;

import java.util.List;

public interface EmailConfigService {

    List<EmailConfig> get(EmailConfig emailConfig);

    Integer insertSelective(EmailConfig emailConfig);

    EmailConfig selectSendEmailAccount();

    List<EmailConfig> selectReceiveEmailAccountWithRedisCache();
}
