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

    private Integer createUserid;

    private Date addtime;

    private Byte view;

    private Date viewTime;

    private Integer viewUserid;

    private Boolean resolve;

    private Date resolveTime;

    private Integer resolveUserid;

    private String exceptionMsg;
}