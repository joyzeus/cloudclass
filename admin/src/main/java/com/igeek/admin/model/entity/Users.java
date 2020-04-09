package com.igeek.admin.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Users extends UsersKey {
    private String email;

    private String password;

    private String nickname;

    private String sex;

    private String headImage;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;

    private Integer loginCount;

    private Boolean locked;

    private Boolean login;


    public static final class Builder {
        private String email;
        private Integer id;
        private String password;
        private String account;
        private String nickname;
        private String mobile;
        private String sex;
        private String headImage;
        private Date createTime;
        private Date updateTime;
        private Date lastLoginTime;
        private Integer loginCount;
        private Boolean locked;
        private Boolean login;

        private Builder() {
        }

        public static Builder anUsers() {
            return new Builder();
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withAccount(String account) {
            this.account = account;
            return this;
        }

        public Builder withNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder withMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder withSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder withHeadImage(String headImage) {
            this.headImage = headImage;
            return this;
        }

        public Builder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder withUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Builder withLastLoginTime(Date lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
            return this;
        }

        public Builder withLoginCount(Integer loginCount) {
            this.loginCount = loginCount;
            return this;
        }

        public Builder withLocked(Boolean locked) {
            this.locked = locked;
            return this;
        }

        public Builder withLogin(Boolean login) {
            this.login = login;
            return this;
        }

        public Users build() {
            Users users = new Users();
            users.setEmail(email);
            users.setId(id);
            users.setPassword(password);
            users.setAccount(account);
            users.setNickname(nickname);
            users.setMobile(mobile);
            users.setSex(sex);
            users.setHeadImage(headImage);
            users.setCreateTime(createTime);
            users.setUpdateTime(updateTime);
            users.setLastLoginTime(lastLoginTime);
            users.setLoginCount(loginCount);
            users.setLocked(locked);
            users.setLogin(login);
            return users;
        }
    }
}