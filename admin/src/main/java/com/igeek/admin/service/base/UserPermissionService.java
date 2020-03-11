package com.igeek.admin.service.base;

import com.igeek.admin.entity.vo.UserPermissionVO;

import java.util.List;

public interface UserPermissionService {

    List<UserPermissionVO> getTopSystem(Integer userId);
}
