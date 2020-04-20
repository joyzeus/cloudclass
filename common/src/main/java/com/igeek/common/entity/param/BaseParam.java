package com.igeek.common.entity.param;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/20 10:32
 */
@Data
@Builder(toBuilder = true)
public class BaseParam implements Serializable {

    private Integer page;

    private Integer offset;
}
