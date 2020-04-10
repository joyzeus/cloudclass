package com.igeek.admin.controller;

import com.igeek.common.util.R;
import com.igeek.admin.service.base.ExceptionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
@RestController
@RequestMapping("/sys/exception")
public class ExceptionLogContorller extends BaseContorller {

    private final ExceptionLogService exceptionLogService;

    @Autowired(required = false)
    public ExceptionLogContorller(ExceptionLogService exceptionLogService) {
        this.exceptionLogService = exceptionLogService;
    }

    @GetMapping("/list")
    public R getExceptionLogList() {
        return R.success(exceptionLogService.selectExceptionList());
    }
}
