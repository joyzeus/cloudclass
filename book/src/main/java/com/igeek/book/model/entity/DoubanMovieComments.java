package com.igeek.book.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class DoubanMovieComments implements Serializable {
    private Integer commentId;

    private String commentInfo;

    private String commentAuthor;

    private String commenterImgUrl;

    private String commentVote;

    private String commentMovie;

    private String recordId;
}