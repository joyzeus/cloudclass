package com.igeek.admin.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jay
 * @date 2020/04/10
 * @email 1419982188@qq.com
 */
@Data
@Builder(toBuilder = true)
public class Role implements Serializable {
    private Integer id;

    private String name;

    private Integer type;

    private Date createTime;

    private Integer createId;
}