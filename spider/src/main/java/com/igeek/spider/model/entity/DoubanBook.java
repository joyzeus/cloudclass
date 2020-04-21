package com.igeek.spider.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@Document(indexName = "books", type = "_doc", shards = 1, replicas = 0)
public class DoubanBook implements Serializable {

    public DoubanBook() {
    }

    public DoubanBook(Integer tableId, Integer bookId, String bookName, Integer typeId, String author, String translator, String publishingHouse, Date publishTime, BigDecimal price, BigDecimal score, Integer rateCount, String link, String img) {
        this.tableId = tableId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.typeId = typeId;
        this.author = author;
        this.translator = translator;
        this.publishingHouse = publishingHouse;
        this.publishTime = publishTime;
        this.price = price;
        this.score = score;
        this.rateCount = rateCount;
        this.link = link;
        this.img = img;
    }

    @Id
    private Integer tableId;
    private Integer bookId;
    //    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String bookName;
    private Integer typeId;
    //    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String author;
    //    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String translator;
    //    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String publishingHouse;
    private Date publishTime;
    private BigDecimal price;
    private BigDecimal score;
    private Integer rateCount;
    private String link;
    private String img;
}