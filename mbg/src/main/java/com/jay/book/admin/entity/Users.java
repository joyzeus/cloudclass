package com.jay.book.admin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Users implements Serializable {
    private Integer tableId;

    private String account;

    private String password;

    private String username;

    private String mobile;

    private String email;

    private Integer sex;

    private String icon;

    private Integer userId;

    private Date createTime;

    private Date updateTime;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableId=").append(tableId);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", username=").append(username);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", icon=").append(icon);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class Builder {
        private Users users;

        private Builder() {
            users = new Users();
        }

        public static Builder anUsers() {
            return new Builder();
        }

        public Builder withTableId(Integer tableId) {
            users.setTableId(tableId);
            return this;
        }

        public Builder withAccount(String account) {
            users.setAccount(account);
            return this;
        }

        public Builder withPassword(String password) {
            users.setPassword(password);
            return this;
        }

        public Builder withUsername(String username) {
            users.setUsername(username);
            return this;
        }

        public Builder withMobile(String mobile) {
            users.setMobile(mobile);
            return this;
        }

        public Builder withEmail(String email) {
            users.setEmail(email);
            return this;
        }

        public Builder withSex(Integer sex) {
            users.setSex(sex);
            return this;
        }

        public Builder withIcon(String icon) {
            users.setIcon(icon);
            return this;
        }

        public Builder withUserId(Integer userId) {
            users.setUserId(userId);
            return this;
        }

        public Builder withCreateTime(Date createTime) {
            users.setCreateTime(createTime);
            return this;
        }

        public Builder withUpdateTime(Date updateTime) {
            users.setUpdateTime(updateTime);
            return this;
        }

        public Users build() {
            return users;
        }
    }
}