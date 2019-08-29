package com.jay.book.admin.entity.model;

import lombok.Data;

import java.util.Date;

@Data
public class LoginLog {
    private Integer tableId;

    private Integer userId;

    private String account;

    private Integer loginSuccess;

    private String ip;

    private String location;

    private String clientType;

    private String clientAgent;

    private String karnelVersion;

    private String useragent;

    private String message;

    private Long spendTime;

    private Date createTime;

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

        public Builder withLoginSuccess(Integer loginSuccess) {
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

        public Builder withClientType(String clientType) {
            loginLog.setClientType(clientType);
            return this;
        }

        public Builder withClientAgent(String clientAgent) {
            loginLog.setClientAgent(clientAgent);
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

        public Builder withMessage(String message) {
            loginLog.setMessage(message);
            return this;
        }

        public Builder withSpendTime(Long spendTime) {
            loginLog.setSpendTime(spendTime);
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