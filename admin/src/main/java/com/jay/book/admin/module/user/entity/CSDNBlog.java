package com.jay.book.admin.module.user.entity;

import lombok.Data;

@Data
public class CSDNBlog {
    private Integer id;

    private Integer articleId;

    private String title;

    private String content;

    private String date;

    private String tag;

    private String category;

    private Integer viewCount;

    private Integer commentCount;

    private Integer copyright;
}