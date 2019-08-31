package com.jay.book.admin.controller;

import com.jay.book.admin.service.base.MenuManageService;
import com.jay.book.admin.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/menu")
public class MenuController extends BaseContorller {

    private final MenuManageService menuManageService;

    public MenuController(MenuManageService menuManageService) {
        this.menuManageService = menuManageService;
    }

    @GetMapping("/menuTree")
    public R getMenuTree() {
        return R.success(menuManageService.getMenuTree());
    }
}
