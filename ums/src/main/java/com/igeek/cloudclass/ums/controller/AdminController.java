package com.igeek.cloudclass.ums.controller;

import com.igeek.cloudclass.ums.model.vo.LoginVO;
import com.igeek.cloudclass.ums.service.UmsAdminService;
import com.igeek.common.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/5/19
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @PostMapping
    public R login(@RequestBody LoginVO loginVO, HttpServletRequest request) {
        return R.success("");
    }
}
