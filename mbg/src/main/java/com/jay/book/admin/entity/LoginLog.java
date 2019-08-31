package com.jay.book.admin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginLog implements Serializable {
    private Integer tableId;

    private Integer userId;

    private String account;

    private Byte loginSuccess;

    private String ip;

    private String location;

    private String deviceType;

    private String agentType;

    private String karnelVersion;

    private String useragent;

    private Long spendTime;

    private String message;

    private Date createTime;

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
        sb.append("]");
        return sb.toString();
    }

    public static final class Builder {
        private LoginLog loginLog;

        private Builder() {
            loginLog = new LoginLog();
        }

        public static Builder aLoginLog() {
            return new Builder();
        }

        public Builder withTableId(Integer tableId) {
            loginLog.setTableId(tableId);
            return this;
        }

        public Builder withUserId(Integer userId) {
            loginLog.setUserId(userId);
            return this;
        }

        public Builder withAccount(String account) {
            loginLog.setAccount(account);
            return this;
        }

        public Builder withLoginSuccess(Byte loginSuccess) {
            loginLog.setLoginSuccess(loginSuccess);
            return this;
        }

        public Builder withIp(String ip) {
            loginLog.setIp(ip);
            return this;
        }

        public Builder withLocation(String location) {
            loginLog.setLocation(location);
            return this;
        }

        public Builder withDeviceType(String deviceType) {
            loginLog.setDeviceType(deviceType);
            return this;
        }

        public Builder withAgentType(String agentType) {
            loginLog.setAgentType(agentType);
            return this;
        }

        public Builder withKarnelVersion(String karnelVersion) {
            loginLog.setKarnelVersion(karnelVersion);
            return this;
        }

        public Builder withUseragent(String useragent) {
            loginLog.setUseragent(useragent);
            return this;
        }

        public Builder withSpendTime(Long spendTime) {
            loginLog.setSpendTime(spendTime);
            return this;
        }

        public Builder withMessage(String message) {
            loginLog.setMessage(message);
            return this;
        }

        public Builder withCreateTime(Date createTime) {
            loginLog.setCreateTime(createTime);
            return this;
        }

        public LoginLog build() {
            return loginLog;
        }
    }
}