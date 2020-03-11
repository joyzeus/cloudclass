package com.igeek.common.util;


public enum HttpCode {

    OK(200, "请求成功"),
    INTERNAL_ERROR(500, "系统异常"),
    EXIT(600, "退出登录");

    private final int code;

    private final String desc;

    HttpCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
