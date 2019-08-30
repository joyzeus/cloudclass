package com.jay.book.module.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    @ApiModelProperty(value = "唯一主键Id")
    private Integer tableId;

    @ApiModelProperty(value = "用户Id")
    private Integer userId;

    @ApiModelProperty(value = "登录使用的账号")
    private String account;

    @ApiModelProperty(value = "是否登录成功")
    private Byte loginSuccess;

    @ApiModelProperty(value = "登录IP")
    private String ip;

    @ApiModelProperty(value = "登录地址")
    private String location;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "代理")
    private String agentType;

    @ApiModelProperty(value = "内核版本")
    private String karnelVersion;

    @ApiModelProperty(value = "代理详细信息")
    private String useragent;

    @ApiModelProperty(value = "登录花费的时间")
    private Long spendTime;

    @ApiModelProperty(value = "登录的日志")
    private String message;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Byte getLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(Byte loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType == null ? null : agentType.trim();
    }

    public String getKarnelVersion() {
        return karnelVersion;
    }

    public void setKarnelVersion(String karnelVersion) {
        this.karnelVersion = karnelVersion == null ? null : karnelVersion.trim();
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent == null ? null : useragent.trim();
    }

    public Long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Long spendTime) {
        this.spendTime = spendTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableId=").append(tableId);
        sb.append(", userId=").append(userId);
        sb.append(", account=").append(account);
        sb.append(", loginSuccess=").append(loginSuccess);
        sb.append(", ip=").append(ip);
        sb.append(", location=").append(location);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", agentType=").append(agentType);
        sb.append(", karnelVersion=").append(karnelVersion);
        sb.append(", useragent=").append(useragent);
        sb.append(", spendTime=").append(spendTime);
        sb.append(", message=").append(message);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}