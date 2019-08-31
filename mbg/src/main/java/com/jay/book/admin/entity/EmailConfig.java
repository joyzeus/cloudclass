package com.jay.book.admin.entity;

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableId=").append(tableId);
        sb.append(", userId=").append(userId);
        sb.append(", account=").append(account);
        sb.append(", accountType=").append(accountType);
        sb.append(", emailType=").append(emailType);
        sb.append(", enable=").append(enable);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append("]");
        return sb.toString();
    }

    public static final class Builder {
        private EmailConfig emailConfig;

        private Builder() {
            emailConfig = new EmailConfig();
        }

        public static Builder anEmailConfig() {
            return new Builder();
        }

        public Builder withTableId(Integer tableId) {
            emailConfig.setTableId(tableId);
            return this;
        }

        public Builder withUserId(Integer userId) {
            emailConfig.setUserId(userId);
            return this;
        }

        public Builder withAccount(String account) {
            emailConfig.setAccount(account);
            return this;
        }

        public Builder withAccountType(String accountType) {
            emailConfig.setAccountType(accountType);
            return this;
        }

        public Builder withEmailType(Integer emailType) {
            emailConfig.setEmailType(emailType);
            return this;
        }

        public Builder withEnable(Boolean enable) {
            emailConfig.setEnable(enable);
            return this;
        }

        public Builder withCreatTime(Date creatTime) {
            emailConfig.setCreatTime(creatTime);
            return this;
        }

        public Builder withUpdateTime(Date updateTime) {
            emailConfig.setUpdateTime(updateTime);
            return this;
        }

        public Builder withUpdateUserId(Integer updateUserId) {
            emailConfig.setUpdateUserId(updateUserId);
            return this;
        }

        public EmailConfig build() {
            return emailConfig;
        }
    }
}