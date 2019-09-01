package com.jay.book.admin.controller;

import com.jay.book.admin.service.base.UserPermissionService;
import com.jay.book.admin.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/permission")
public class UserPermissionController extends BaseContorller {

    private final UserPermissionService userPermissionService;

    @Autowired
    public UserPermissionController(UserPermissionService userPermissionService) {
        this.userPermissionService = userPermissionService;
    }

    @GetMapping("/topSystem")
    public R getTopSystem() {
        return R.success(userPermissionService.getTopSystem());
    }
}
