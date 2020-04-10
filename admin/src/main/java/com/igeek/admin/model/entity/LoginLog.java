package com.igeek.admin.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhouxu
 * @date 2020/04/10
 * @email 1419982188@qq.com
 */
@Data
@Builder(toBuilder = true)
public class LoginLog implements Serializable {
    private Integer id;

    private Long userId;

    private String account;

    private Date createTime;

    private String ip;

    private String location;

    private String deviceType;

    private String agentType;

    private String karnelVersion;

    private String useragent;

    private String message;

    private Integer loginSuccess;

    private Long spendTime;

    private String requestParams;
}