package com.jay.book.admin.entity.model;

import lombok.Data;

import java.util.Date;

@Data
public class ExceptionLog {
    private Integer id;

    private String className;

    private String methodName;

    private String exceptionType;

    private String ip;

    private Integer createUserid;

    private Date addtime;

    private Byte view;

    private Date viewTime;

    private Integer viewUserid;

    private Boolean resolve;

    private Date resolveTime;

    private Integer resolveUserid;

    private String exceptionMsg;

    public static final class Builder {
        private ExceptionLog exceptionLog;

        private Builder() {
            exceptionLog = new ExceptionLog();
        }

        public static Builder anExceptionLog() {
            return new Builder();
        }

        public Builder withId(Integer id) {
            exceptionLog.setId(id);
            return this;
        }

        public Builder withClassName(String className) {
            exceptionLog.setClassName(className);
            return this;
        }

        public Builder withMethodName(String methodName) {
            exceptionLog.setMethodName(methodName);
            return this;
        }

        public Builder withExceptionType(String exceptionType) {
            exceptionLog.setExceptionType(exceptionType);
            return this;
        }

        public Builder withIp(String ip) {
            exceptionLog.setIp(ip);
            return this;
        }

        public Builder withCreateUserid(Integer createUserid) {
            exceptionLog.setCreateUserid(createUserid);
            return this;
        }

        public Builder withAddtime(Date addtime) {
            exceptionLog.setAddtime(addtime);
            return this;
        }

        public Builder withView(Byte view) {
            exceptionLog.setView(view);
            return this;
        }

        public Builder withViewTime(Date viewTime) {
            exceptionLog.setViewTime(viewTime);
            return this;
        }

        public Builder withViewUserid(Integer viewUserid) {
            exceptionLog.setViewUserid(viewUserid);
            return this;
        }

        public Builder withResolve(Boolean resolve) {
            exceptionLog.setResolve(resolve);
            return this;
        }

        public Builder withResolveTime(Date resolveTime) {
            exceptionLog.setResolveTime(resolveTime);
            return this;
        }

        public Builder withResolveUserid(Integer resolveUserid) {
            exceptionLog.setResolveUserid(resolveUserid);
            return this;
        }

        public Builder withExceptionMsg(String exceptionMsg) {
            exceptionLog.setExceptionMsg(exceptionMsg);
            return this;
        }

        public ExceptionLog build() {
            return exceptionLog;
        }
    }
}