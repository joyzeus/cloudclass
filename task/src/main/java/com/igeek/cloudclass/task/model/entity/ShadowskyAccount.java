package com.igeek.cloudclass.task.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/05/02
 */
@Data
@Builder(toBuilder = true)
public class ShadowskyAccount implements Serializable {
    private Integer id;

    private String account;

    private String password;
}