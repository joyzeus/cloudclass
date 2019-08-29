package com.jay.book.module.book.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class DoubanBookType implements Serializable {
    private Integer tableId;

    private String type;

    private String link;

    private Integer count;

    public static final class Builder {
        private DoubanBookType doubanBookType;

        private Builder() {
            doubanBookType = new DoubanBookType();
        }

        public static Builder aDoubanBookType() {
            return new Builder();
        }

        public Builder withTableId(Integer tableId) {
            doubanBookType.setTableId(tableId);
            return this;
        }

        public Builder withType(String type) {
            doubanBookType.setType(type);
            return this;
        }

        public Builder withLink(String link) {
            doubanBookType.setLink(link);
            return this;
        }

        public Builder withCount(Integer count) {
            doubanBookType.setCount(count);
            return this;
        }

        public DoubanBookType build() {
            return doubanBookType;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubanBookType that = (DoubanBookType) o;
        return type.equals(that.type) &&
                link.equals(that.link) &&
                count.equals(that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, link, count);
    }
}