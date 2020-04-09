package com.igeek.admin.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EmailConfig implements Serializable {
    private Integer tableId;

    private Integer userId;

    private String account;

    private String accountType;

    private Integer emailType;

    private Boolean enable;

    private Date creatTime;

    private Date updateTime;

    private Integer updateUserId;

    public static final class Builder {
        private Integer tableId;
        private Integer userId;
        private String account;
        private String accountType;
        private Integer emailType;
        private Boolean enable;
        private Date creatTime;
        private Date updateTime;
        private Integer updateUserId;

        private Builder() {
        }

        public static Builder anEmailConfig() {
            return new Builder();
        }

        public Builder withTableId(Integer tableId) {
            this.tableId = tableId;
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

        public Builder withAccountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder withEmailType(Integer emailType) {
            this.emailType = emailType;
            return this;
        }

        public Builder withEnable(Boolean enable) {
            this.enable = enable;
            return this;
        }

        public Builder withCreatTime(Date creatTime) {
            this.creatTime = creatTime;
            return this;
        }

        public Builder withUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Builder withUpdateUserId(Integer updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

        public EmailConfig build() {
            EmailConfig emailConfig = new EmailConfig();
            emailConfig.setTableId(tableId);
            emailConfig.setUserId(userId);
            emailConfig.setAccount(account);
            emailConfig.setAccountType(accountType);
            emailConfig.setEmailType(emailType);
            emailConfig.setEnable(enable);
            emailConfig.setCreatTime(creatTime);
            emailConfig.setUpdateTime(updateTime);
            emailConfig.setUpdateUserId(updateUserId);
            return emailConfig;
        }
    }
}