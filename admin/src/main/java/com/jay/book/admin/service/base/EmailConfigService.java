package com.jay.book.admin.service.base;

import com.jay.book.module.admin.entity.EmailConfig;

import java.util.List;

public interface EmailConfigService {

    List<EmailConfig> get(EmailConfig emailConfig);

    Integer insertSelective(EmailConfig emailConfig);

    EmailConfig selectSendEmailAccount();

    List<EmailConfig> selectReceiveEmailAccountWithRedisCache();
}
