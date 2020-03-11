package com.igeek.admin.dao;

import com.igeek.admin.entity.EmailConfig;

import java.util.List;

public interface EmailConfigMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(EmailConfig record);

    int insertSelective(EmailConfig record);

    EmailConfig selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(EmailConfig record);

    int updateByPrimaryKey(EmailConfig record);

    List<EmailConfig> list(EmailConfig emailConfig);
}