package com.igeek.crm.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class Classes implements Serializable {
    private Integer tableId;

    private String name;

    private Integer parentId;

    private Byte enable;

    private Integer orderId;
}