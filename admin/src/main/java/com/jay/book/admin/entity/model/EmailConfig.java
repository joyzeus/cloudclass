package com.jay.book.admin.entity.model;

import lombok.Data;

import java.util.Date;

@Data
public class EmailConfig {
    private Integer tableId;

    private Integer userId;

    private String account;

    private String password;

    private String accountType;

    private Integer emailType;

    private Boolean enable;

    private Date creatTime;

    private Date updateTime;

    private Integer updateUserId;

    public static final class Builder {
        private EmailConfig emailConfig;

        private Builder() {
            emailConfig = new EmailConfig();
        }

        public static Builder anEmailConfig() {
            return new Builder();
        }

        public Builder tableId(Integer tableId) {
            emailConfig.setTableId(tableId);
            return this;
        }

        public Builder userId(Integer userId) {
            emailConfig.setUserId(userId);
            return this;
        }

        public Builder account(String account) {
            emailConfig.setAccount(account);
            return this;
        }

        public Builder password(String password) {
            emailConfig.setPassword(password);
            return this;
        }

        public Builder accountType(String accountType) {
            emailConfig.setAccountType(accountType);
            return this;
        }

        public Builder emailType(Integer emailType) {
            emailConfig.setEmailType(emailType);
            return this;
        }

        public Builder enable(Boolean enable) {
            emailConfig.setEnable(enable);
            return this;
        }

        public Builder creatTime(Date creatTime) {
            emailConfig.setCreatTime(creatTime);
            return this;
        }

        public Builder updateTime(Date updateTime) {
            emailConfig.setUpdateTime(updateTime);
            return this;
        }

        public Builder updateUserId(Integer updateUserId) {
            emailConfig.setUpdateUserId(updateUserId);
            return this;
        }

        public EmailConfig build() {
            return emailConfig;
        }
    }
}