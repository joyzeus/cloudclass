package com.igeek.crm.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Customer implements Serializable {
    private Integer tableId;

    private String mobile;

    private Integer classes;

    private Integer userId;

    private Integer dept;

    private Integer status;

    private Integer promoteTypeId;

    private Integer promoteId;

    private String originUrl;

    private Integer trackUserId;

    private Date trackAllocationTime;

    private Integer trackAllocationType;

    private Integer createUserId;

    private Date createTime;
}