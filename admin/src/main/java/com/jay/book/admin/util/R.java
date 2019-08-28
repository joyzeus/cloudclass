package com.jay.book.admin.util;

import java.util.HashMap;

public class R extends HashMap<String, Object> {

    public static R ok() {
        return new R().setCode(HttpCode.OK.getCode()).setMessage(HttpCode.OK.getDesc());
    }

    public static R error() {
        return error(HttpCode.INTERNAL_ERROR.getDesc());
    }

    public static R error(String message) {
        return new R().setCode(HttpCode.INTERNAL_ERROR.getCode()).setMessage(message);
    }

    public static R error(int code, String message) {
        return new R().setCode(code).setMessage(message);
    }

    public R setCode(int code) {
        return put("code", code);
    }

    public R setMessage(String message) {
        return put("message", message);
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}