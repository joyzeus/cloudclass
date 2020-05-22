package com.igeek.cloudclass.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/5/22
 */
@RestController
public class TestController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
