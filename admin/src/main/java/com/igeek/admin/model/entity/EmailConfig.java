package com.igeek.admin.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
public class EmailConfig implements Serializable {
    private Integer tableId;

    private Integer userId;

    private String account;

    private String accountType;

    private Integer emailType;

    private Boolean enable;

    private Date createTime;

    private Date updateTime;

    private Integer updateUserId;
}