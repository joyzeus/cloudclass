package com.igeek.admin.constant;
/**
 * @author zhouxu
 * @date 2019/12/24
 */
public enum RedisKeyEnum {

    VERTIFICATIONCDOE("sys:user:code:", "验证码"),
    TOKEN("sys:user:token:", "通过userid查询token"),
    SEND_EMAIL_LIST("sys:config:email:send", "发送邮件的账号"),
    RECEIVE_EMAIL_LIST("sys:config:email:receive", "接受邮件的账号"),
    PERMISSION_TREE("sys:config:permission:tree", "权限树");

    String key;
    String desc;

    RedisKeyEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
