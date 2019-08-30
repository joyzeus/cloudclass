package com.jay.book.admin.service.impl;

import com.jay.book.admin.config.redis.RedisUtil;
import com.jay.book.admin.constant.RedisKeyEnum;
import com.jay.book.admin.dao.PermissionMapper;
import com.jay.book.admin.entity.Permission;
import com.jay.book.admin.entity.vo.PermissionVO;
import com.jay.book.admin.service.base.MenuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public List<PermissionVO> getMenuTree(){
        List<Permission> data = new ArrayList<>();
        String key = RedisKeyEnum.PERMISSION_TREE.getKey();
        if (redisUtil.has(key)){
            return redisUtil.getList(key, PermissionVO.class);
        }else {
            permissionMapper.sele
        }

        return data;
    }
}