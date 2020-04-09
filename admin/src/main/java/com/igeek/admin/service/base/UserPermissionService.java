package com.igeek.admin.service.base;

import com.igeek.admin.model.entity.vo.UserPermissionVO;

import java.util.List;

public interface UserPermissionService {

    List<UserPermissionVO> getTopSystem(Integer userId);
}
