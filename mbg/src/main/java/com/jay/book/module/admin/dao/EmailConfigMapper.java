package com.jay.book.module.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.module.admin.entity.EmailConfig;
import java.util.List;

public interface EmailConfigMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(EmailConfig record);

    int insertSelective(EmailConfig record);

    EmailConfig selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(EmailConfig record);

    int updateByPrimaryKey(EmailConfig record);

    EmailConfig find(EmailConfig record);

    List<EmailConfig> list(EmailConfig record);

    Page<EmailConfig> pageList(EmailConfig record);
}