package com.jay.book.admin.module.user.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LoginLog {
    private Integer tableId;

    private Integer userId;

    private Date createTime;

    private String ip;

    private String location;

    private String clientType;

    private String clientAgent;

    private String karnelVersion;

    private String useragent;

    private String message;

    public static final class LoginLogBuilder {
        private LoginLog loginLog;

        private LoginLogBuilder() {
            loginLog = new LoginLog();
        }

        public static LoginLogBuilder aLoginLog() {
            return new LoginLogBuilder();
        }

        public LoginLogBuilder withTableId(Integer tableId) {
            loginLog.setTableId(tableId);
            return this;
        }

        public LoginLogBuilder withUserId(Integer userId) {
            loginLog.setUserId(userId);
            return this;
        }

        public LoginLogBuilder withCreateTime(Date createTime) {
            loginLog.setCreateTime(createTime);
            return this;
        }

        public LoginLogBuilder withIp(String ip) {
            loginLog.setIp(ip);
            return this;
        }

        public LoginLogBuilder withLocation(String location) {
            loginLog.setLocation(location);
            return this;
        }

        public LoginLogBuilder withClientType(String clientType) {
            loginLog.setClientType(clientType);
            return this;
        }

        public LoginLogBuilder withClientAgent(String clientAgent) {
            loginLog.setClientAgent(clientAgent);
            return this;
        }

        public LoginLogBuilder withKarnelVersion(String karnelVersion) {
            loginLog.setKarnelVersion(karnelVersion);
            return this;
        }

        public LoginLogBuilder withUseragent(String useragent) {
            loginLog.setUseragent(useragent);
            return this;
        }

        public LoginLogBuilder withMessage(String message) {
            loginLog.setMessage(message);
            return this;
        }

        public LoginLog build() {
            return loginLog;
        }
    }
}