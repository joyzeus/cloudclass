package com.igeek.cloudclass.task.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/05/02
 */
@Data
@Builder(toBuilder = true)
public class ShadowskySigninLog implements Serializable {
    private Integer id;

    private String account;

    private Date createTime;

    private String result;
}