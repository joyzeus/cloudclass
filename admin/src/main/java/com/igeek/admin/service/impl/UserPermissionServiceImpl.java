package com.igeek.admin.service.impl;

import com.igeek.admin.dao.UserPermissionMapper;
import com.igeek.admin.model.entity.RolePermissionRelation;
import com.igeek.admin.model.entity.vo.UserPermissionVO;
import com.igeek.admin.service.base.MenuManageService;
import com.igeek.admin.service.base.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    @Autowired(required = false)
    private UserPermissionMapper userPermissionMapper;
    @Autowired(required = false)
    private MenuManageService menuManageService;

    @Override
    public List<UserPermissionVO> getTopSystem(Integer userId) {
        return null;
    }

    @Override
    public List<RolePermissionRelation> getAllMenusWithRole() {
        return null;
    }
}
