package com.igeek.spider.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder(toBuilder = true)
public class DoubanBook implements Serializable {
    private Integer tableId;

    private Integer bookId;

    private String bookName;

    private Integer typeId;

    private String author;

    private String translator;

    private String publishingHouse;

    private Date publishTime;

    private BigDecimal price;

    private BigDecimal score;

    private Integer rateCount;

    private String link;

    private String img;
}