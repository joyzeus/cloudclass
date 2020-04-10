package com.igeek.admin.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class  ErrorLog implements Serializable {
    private Integer id;

    private Date createTime;

    private Integer type;

    private String url;

    private String message;
}