package com.jay.book.admin.entity.vo;

import com.jay.book.admin.entity.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PermissionVO extends Permission {

    List<PermissionVO> childList;

    public static PermissionVO createInstance(Permission permission) {
        PermissionVO permissionVO = new PermissionVO();
        permissionVO.setTableId(permission.getTableId());
        permissionVO.setNodeName(permission.getNodeName());
        permissionVO.setPath(permission.getPath());
        permissionVO.setParentId(permission.getParentId());
        permissionVO.setHasChild(permission.getHasChild());
        permissionVO.setType(permission.getType());
        permissionVO.setOrderId(permission.getOrderId());
        permissionVO.setActived(permission.getActived());
        permissionVO.setDeleted(permission.getDeleted());
        return permissionVO;
    }
}
