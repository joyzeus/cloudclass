package com.igeek.crm.model.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/22 16:09
 */
public class ClassesForm implements Serializable {
    private Integer tableId;

    @NotBlank(message = "名称不能为空")
    private String name;

    @NotNull(message = "父级Id不能为空")
    private Integer parentId;

    private Byte enable;

    private Integer orderId;
}
