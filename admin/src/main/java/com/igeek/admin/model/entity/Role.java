package com.igeek.admin.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Role implements Serializable {
    private Integer id;

    private String name;

    private Integer type;

    private Date createTime;

    private Integer createId;

}