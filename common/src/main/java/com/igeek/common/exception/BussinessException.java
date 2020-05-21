package com.igeek.common.exception;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/5/19
 */
public class BussinessException extends RuntimeException {

    private String info;

    public BussinessException(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
