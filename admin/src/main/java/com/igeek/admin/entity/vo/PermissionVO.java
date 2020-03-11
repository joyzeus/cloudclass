package com.igeek.admin.entity.vo;

import com.igeek.admin.entity.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
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
