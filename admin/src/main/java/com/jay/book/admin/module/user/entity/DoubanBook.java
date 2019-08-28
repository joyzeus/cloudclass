package com.jay.book.admin.module.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
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

    public static final class Builder {
        private DoubanBook doubanBook;

        private Builder() {
            doubanBook = new DoubanBook();
        }

        public static Builder aDoubanBook() {
            return new Builder();
        }

        public Builder withTableId(Integer tableId) {
            doubanBook.setTableId(tableId);
            return this;
        }

        public Builder withBookId(Integer bookId) {
            doubanBook.setBookId(bookId);
            return this;
        }

        public Builder withBookName(String name) {
            doubanBook.setBookName(name);
            return this;
        }

        public Builder withTypeId(Integer typeId) {
            doubanBook.setTypeId(typeId);
            return this;
        }

        public Builder withAuthor(String author) {
            doubanBook.setAuthor(author);
            return this;
        }

        public Builder withTranslator(String translator) {
            doubanBook.setTranslator(translator);
            return this;
        }

        public Builder withPublishingHouse(String publishingHouse) {
            doubanBook.setPublishingHouse(publishingHouse);
            return this;
        }

        public Builder withPublishTime(Date publishTime) {
            doubanBook.setPublishTime(publishTime);
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            doubanBook.setPrice(price);
            return this;
        }

        public Builder withScore(BigDecimal score) {
            doubanBook.setScore(score);
            return this;
        }

        public Builder withRateCount(Integer rateCount) {
            doubanBook.setRateCount(rateCount);
            return this;
        }

        public Builder withLink(String link) {
            doubanBook.setLink(link);
            return this;
        }

        public Builder withImg(String img) {
            doubanBook.setImg(img);
            return this;
        }

        public DoubanBook build() {
            return doubanBook;
        }
    }
}