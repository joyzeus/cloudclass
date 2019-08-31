package com.jay.book.admin.service.base;

import com.jay.book.admin.entity.vo.PermissionVO;

import java.util.List;

/**
 * 菜单权限管理服务
 */
public interface MenuManageService {

    List<PermissionVO> getMenuTree();
}
