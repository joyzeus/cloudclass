package com.igeek.admin.controller;

import com.igeek.admin.service.base.MenuManageService;
import com.igeek.common.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController extends BaseContorller {

    @Autowired
    private MenuManageService menuManageService;

    @GetMapping("/menuTree/{parentId}")
    public R getMenuTree(@PathVariable Integer parentId) {
        return R.success(menuManageService.getChildMenuTree(parentId));
    }

    @GetMapping("/childTree/{parentId}")
    public R getChildMenuTree(@PathVariable Integer parentId) {
        return R.success(menuManageService.getChildMenuTree(parentId));
    }
}
