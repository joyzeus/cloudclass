package com.igeek.book.model.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/20 10:28
 */
@Data
@Builder(toBuilder = true)
public class BookModel implements Serializable {
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
