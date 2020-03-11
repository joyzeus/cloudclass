package com.igeek.admin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginLog implements Serializable {
    private Integer id;

    private Integer userId;

    private String account;

    private Date createTime;

    private String ip;

    private String location;

    private String deviceType;

    private String agentType;

    private String karnelVersion;

    private String useragent;

    private String message;

    private Integer loginSuccess;

    private Long spendTime;


    public static final class Builder {
        private Integer id;
        private Integer userId;
        private String account;
        private Date createTime;
        private String ip;
        private String location;
        private String deviceType;
        private String agentType;
        private String karnelVersion;
        private String useragent;
        private String message;
        private Integer loginSuccess;
        private Long spendTime;

        private Builder() {
        }

        public static Builder aLoginLog() {
            return new Builder();
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder withAccount(String account) {
            this.account = account;
            return this;
        }

        public Builder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder withIp(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withDeviceType(String deviceType) {
            this.deviceType = deviceType;
            return this;
        }

        public Builder withAgentType(String agentType) {
            this.agentType = agentType;
            return this;
        }

        public Builder withKarnelVersion(String karnelVersion) {
            this.karnelVersion = karnelVersion;
            return this;
        }

        public Builder withUseragent(String useragent) {
            this.useragent = useragent;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withLoginSuccess(Integer loginSuccess) {
            this.loginSuccess = loginSuccess;
            return this;
        }

        public Builder withSpendTime(Long spendTime) {
            this.spendTime = spendTime;
            return this;
        }

        public LoginLog build() {
            LoginLog loginLog = new LoginLog();
            loginLog.setId(id);
            loginLog.setUserId(userId);
            loginLog.setAccount(account);
            loginLog.setCreateTime(createTime);
            loginLog.setIp(ip);
            loginLog.setLocation(location);
            loginLog.setDeviceType(deviceType);
            loginLog.setAgentType(agentType);
            loginLog.setKarnelVersion(karnelVersion);
            loginLog.setUseragent(useragent);
            loginLog.setMessage(message);
            loginLog.setLoginSuccess(loginSuccess);
            loginLog.setSpendTime(spendTime);
            return loginLog;
        }
    }
}