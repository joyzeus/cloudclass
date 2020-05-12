package com.igeek.admin.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExceptionLog implements Serializable {
    private Integer id;

    private String className;

    private String methodName;

    private String exceptionType;

    private String ip;

    private Integer createUserId;

    private Date createTime;

    private Byte view;

    private Date viewTime;

    private Integer viewUserId;

    private Boolean resolve;

    private Date resolveTime;

    private Integer resolveUserId;

    private String exceptionMsg;
}