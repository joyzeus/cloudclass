package com.jay.book.admin.entity.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Users implements Serializable {
    private Integer tableId;

    private String account;

    private String password;

    private String mobile;

    private String email;

    private Integer userId;

    private Integer sex;

    private String icon;

    private Date createTime;

    private Date updateTime;

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

        public Builder withMobile(String mobile) {
            users.setMobile(mobile);
            return this;
        }

        public Builder withEmail(String email) {
            users.setEmail(email);
            return this;
        }

        public Builder withUserId(Integer userId) {
            users.setUserId(userId);
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