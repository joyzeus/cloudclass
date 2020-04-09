package com.igeek.spider.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class DoubanBookType implements Serializable {
    private Integer tableId;

    private String type;

    private String link;

    private Integer count;
}