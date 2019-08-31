package com.jay.book.admin.dao;

import com.github.pagehelper.Page;
import com.jay.book.admin.entity.EmailConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
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