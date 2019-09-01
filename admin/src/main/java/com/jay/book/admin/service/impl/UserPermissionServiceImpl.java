package com.jay.book.admin.service.impl;

import com.jay.book.admin.dao.UserPermissionMapper;
import com.jay.book.admin.entity.vo.UserPermissionVO;
import com.jay.book.admin.service.base.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    private final UserPermissionMapper userPermissionMapper;

    @Autowired(required = false)
    public UserPermissionServiceImpl(UserPermissionMapper userPermissionMapper) {
        this.userPermissionMapper = userPermissionMapper;
    }

    public List<UserPermissionVO> getTopSystem(){
        return null;
    }
}
