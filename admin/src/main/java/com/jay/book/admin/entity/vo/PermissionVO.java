package com.jay.book.admin.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PermissionVO extends Permission {

    List<Permission> childList;
}
