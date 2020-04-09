package com.igeek.admin.service.impl;

import com.igeek.admin.config.redis.RedisUtil;
import com.igeek.admin.constant.RedisKeyEnum;
import com.igeek.admin.dao.PermissionMapper;
import com.igeek.admin.model.entity.Permission;
import com.igeek.admin.model.entity.vo.PermissionVO;
import com.igeek.admin.service.base.MenuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuManageServiceImpl implements MenuManageService {

    @Autowired(required = false)
    private PermissionMapper permissionMapper;

    @Autowired(required = false)
    private RedisUtil redisUtil;

    public List<PermissionVO> getMenuTree() {
        return getChildMenuTree(0);
    }

    @Override
    public List<PermissionVO> getChildMenuTree(Integer parentId) {
        List<Permission> data;
        String key = RedisKeyEnum.PERMISSION_TREE.getKey();
        if (redisUtil.has(key)) {
            data = redisUtil.getList(key, Permission.class);
        } else {
            data = permissionMapper.list(null);
            if (data != null && data.size() > 0) {
                redisUtil.set(key, data);
            }
        }
        return toTree(data, parentId);
    }

    List<PermissionVO> toTree(List<Permission> list, Integer parentId) {
        List<PermissionVO> permissionVOList = new ArrayList<>();
        List<Permission> permissionList = list.stream().filter(t -> t != null && t.getParentId() != null && t.getParentId().intValue() == parentId).distinct().collect(Collectors.toList());
        permissionList.forEach(t -> {
            PermissionVO instance = PermissionVO.createInstance(t);
            permissionVOList.add(instance);
            instance.setChildList(toTree(list, t.getTableId()));
        });
        return permissionVOList;
    }
}
