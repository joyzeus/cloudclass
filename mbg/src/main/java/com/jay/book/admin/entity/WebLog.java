package com.jay.book.admin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WebLog implements Serializable {
    private Integer tableId;

    private Integer userId;

    private Date startTime;

    private Integer spendTime;

    private String basePath;

    private String uri;

    private String url;

    private String method;

    private String ip;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableId=").append(tableId);
        sb.append(", userId=").append(userId);
        sb.append(", startTime=").append(startTime);
        sb.append(", spendTime=").append(spendTime);
        sb.append(", basePath=").append(basePath);
        sb.append(", uri=").append(uri);
        sb.append(", url=").append(url);
        sb.append(", method=").append(method);
        sb.append(", ip=").append(ip);
        sb.append("]");
        return sb.toString();
    }

    public static final class Builder {
        private WebLog webLog;

        private Builder() {
            webLog = new WebLog();
        }

        public static Builder aWebLog() {
            return new Builder();
        }

        public Builder withTableId(Integer tableId) {
            webLog.setTableId(tableId);
            return this;
        }

        public Builder withUserId(Integer userId) {
            webLog.setUserId(userId);
            return this;
        }

        public Builder withStartTime(Date startTime) {
            webLog.setStartTime(startTime);
            return this;
        }

        public Builder withSpendTime(Integer spendTime) {
            webLog.setSpendTime(spendTime);
            return this;
        }

        public Builder withBasePath(String basePath) {
            webLog.setBasePath(basePath);
            return this;
        }

        public Builder withUri(String uri) {
            webLog.setUri(uri);
            return this;
        }

        public Builder withUrl(String url) {
            webLog.setUrl(url);
            return this;
        }

        public Builder withMethod(String method) {
            webLog.setMethod(method);
            return this;
        }

        public Builder withIp(String ip) {
            webLog.setIp(ip);
            return this;
        }

        public WebLog build() {
            return webLog;
        }
    }
}