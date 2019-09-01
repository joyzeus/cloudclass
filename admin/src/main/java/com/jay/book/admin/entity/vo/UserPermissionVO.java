package com.jay.book.admin.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPermissionVO implements Serializable {

    private Integer id;
    private String name;
    private String path;
}
