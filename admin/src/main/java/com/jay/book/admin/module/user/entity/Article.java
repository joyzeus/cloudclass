package com.jay.book.admin.module.user.entity;

import lombok.Data;

@Data
public class Article {

    private int articleId;
    /**
     * 类型
     **/
    private String type;
    /**
     * 作者
     **/
    private String author;
    /**
     * 朝代
     **/
    private String dynasty;
    /**
     * 作者简介
     **/
    private String authorInfo;
    /**
     * 标题
     **/
    private String title;
    /**
     * 原文
     **/
    private String content;
    /**
     * 译文
     **/
    private String translation;
    /**
     * 注释
     **/
    private String comment;
    /**
     * 赏析
     **/
    private String appreciation;
    /**
     * UUID
     **/
    private String id;
    /**
     * 匹配度
     **/
    private float score;
}