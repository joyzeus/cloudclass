package com.igeek.spider.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
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
//    @Field(name = "table_id")
    @JsonProperty("table_id")
    private Integer tableId;
    //    @Field(name = "book_id")
    @JsonProperty("book_id")
    private Integer bookId;
    //    @Field(name = "book_name")
    @JsonProperty("book_name")
    private String bookName;
    //    @Field(name = "type_id")
    @JsonProperty("type_id")
    private Integer typeId;
    //    @Field(name = "author")
    @JsonProperty("author")
    private String author;
    //    @Field(name = "translator")
    @JsonProperty("translator")
    private String translator;
    //    @Field(name = "publishing_house")
    @JsonProperty("publishing_house")
    private String publishingHouse;
    //    @Field(name = "publish_time")
    @JsonProperty("publish_time")
    private Date publishTime;
    //    @Field(name = "price")
    @JsonProperty("price")
    private BigDecimal price;
    //    @Field(name = "score")
    @JsonProperty("score")
    private BigDecimal score;
    //    @Field(name = "rate_count")
    @JsonProperty("rate_count")
    private Integer rateCount;
    //    @Field(name = "link")
    @JsonProperty("link")
    private String link;
    //    @Field(name = "img")
    @JsonProperty("img")
    private String img;
}