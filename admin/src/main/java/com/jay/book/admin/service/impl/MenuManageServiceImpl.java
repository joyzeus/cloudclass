package com.jay.book.admin.service.impl;

import com.jay.book.admin.config.redis.RedisUtil;
import com.jay.book.admin.constant.RedisKeyEnum;
import com.jay.book.admin.entity.vo.PermissionVO;
import com.jay.book.admin.service.base.MenuManageService;
import com.jay.book.admin.dao.PermissionMapper;
import com.jay.book.admin.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class MenuManageServiceImpl implements MenuManageService {

    private final PermissionMapper permissionMapper;

    private final RedisUtil redisUtil;

    @Autowired(required = false)
    public MenuManageServiceImpl(PermissionMapper permissionMapper, RedisUtil redisUtil) {
        this.permissionMapper = permissionMapper;
        this.redisUtil = redisUtil;
    }

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
