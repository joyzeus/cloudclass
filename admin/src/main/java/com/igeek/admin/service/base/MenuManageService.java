package com.igeek.admin.service.base;


import com.igeek.admin.entity.vo.PermissionVO;

import java.util.List;

/**
 * 菜单权限管理服务
 */
public interface MenuManageService {

    List<PermissionVO> getMenuTree();

    List<PermissionVO> getChildMenuTree(Integer parentId);
}
