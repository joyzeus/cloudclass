package com.igeek.admin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WebLog implements Serializable {
    private Integer id;

    private Integer userId;

    private Date startTime;

    private Integer spendTime;

    private String basePath;

    private String uri;

    private String url;

    private String method;

    private String ip;

}