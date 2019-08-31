package com.jay.book.admin.service.impl;

import com.jay.book.admin.constant.RedisKeyEnum;
import com.jay.book.admin.config.redis.RedisUtil;
import com.jay.book.admin.service.base.EmailConfigService;
import com.jay.book.admin.dao.EmailConfigMapper;
import com.jay.book.admin.entity.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailConfigServiceImpl implements EmailConfigService {

    private final EmailConfigMapper emailConfigMapper;

    private final RedisUtil redisUtil;

    @Autowired(required = false)
    public EmailConfigServiceImpl(EmailConfigMapper emailConfigMapper, RedisUtil redisUtil) {
        this.emailConfigMapper = emailConfigMapper;
        this.redisUtil = redisUtil;
    }

    @Override
    public List<EmailConfig> get(EmailConfig emailConfig) {
        return emailConfigMapper.list(emailConfig);
    }

    @Override
    public Integer insertSelective(EmailConfig emailConfig) {
        Integer emailType = emailConfig.getEmailType();
        if (emailType != null && emailType == 1) {
            emailConfig.setEnable(true);
        }
        int count = emailConfigMapper.insertSelective(emailConfig);
        // 发邮件账号
        // 禁用掉其他发件账号
        if (emailType != null && emailType == 1 && emailConfig.getTableId() != null) {
//            emailConfigMapper.resetSendEmailAccount(emailConfig.getTableId());
            //重置一下邮件服务
            String key = RedisKeyEnum.SEND_EMAIL_LIST.getKey();
            if (redisUtil.has(key)) {
                redisUtil.delete(key);
            }
        }

        //重置收件人缓存
        if (emailType != null && emailType == 1) {
            String key = RedisKeyEnum.RECEIVE_EMAIL_LIST.getKey();
            if (redisUtil.has(key)) {
                redisUtil.delete(key);
            }
        }
        return count;
    }

    @Override
    public EmailConfig selectSendEmailAccount() {
        String key = RedisKeyEnum.SEND_EMAIL_LIST.getKey();
        if (redisUtil.has(key)) {
            return redisUtil.get(key, EmailConfig.class);
        } else {
            List<EmailConfig> emailConfigList = emailConfigMapper.list(EmailConfig.Builder.anEmailConfig()
                    .withEmailType(1)
                    .withEnable(true)
                    .build());
            EmailConfig emailConfig = null;
            if (emailConfigList != null && emailConfigList.size() > 0) {
                emailConfig = emailConfigList.get(0);
                redisUtil.set(key, emailConfig);
            }
            return emailConfig;
        }
    }

    @Override
    public List<EmailConfig> selectReceiveEmailAccountWithRedisCache() {
        String key = RedisKeyEnum.RECEIVE_EMAIL_LIST.getKey();
        if (redisUtil.has(key)) {
            return redisUtil.getList(key, EmailConfig.class);
        } else {
            List<EmailConfig> emailConfigList = emailConfigMapper.list(EmailConfig.Builder.anEmailConfig()
                    .withEmailType(2)
                    .withEnable(true)
                    .build());
            if (emailConfigList != null && emailConfigList.size() > 0) {
                redisUtil.set(key, emailConfigList);
            }
            return emailConfigList;
        }
    }
}
