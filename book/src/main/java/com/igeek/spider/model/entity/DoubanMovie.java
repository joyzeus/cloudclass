package com.igeek.spider.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
public class DoubanMovie implements Serializable {
    private Integer movieId;

    private String director;

    private String scenarist;

    private String actors;

    private String type;

    private String country;

    private String language;

    private Date releaseDate;

    private String duration;

    private String ratingNum;

    private String tags;

    private String name;
}