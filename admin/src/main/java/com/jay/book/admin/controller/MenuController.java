package com.jay.book.admin.controller;

import com.jay.book.admin.service.base.MenuManageService;
import com.jay.book.admin.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/menu")
public class MenuController extends BaseContorller {

    private final MenuManageService menuManageService;

    public MenuController(MenuManageService menuManageService) {
        this.menuManageService = menuManageService;
    }

    @GetMapping("/menuTree/{parentId}")
    public R getMenuTree(@PathVariable Integer parentId) {
        return R.success(menuManageService.getChildMenuTree(parentId));
    }

    @GetMapping("/childTree/{parentId}")
    public R getChildMenuTree(@PathVariable Integer parentId) {
        return R.success(menuManageService.getChildMenuTree(parentId));
    }
}
