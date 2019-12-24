package com.jay.book.admin.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
@Data
public class UserPermissionVO implements Serializable {

    private Integer id;
    private String name;
    private String path;
}
