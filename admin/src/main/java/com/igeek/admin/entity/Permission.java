package com.igeek.admin.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
    private Integer tableId;

    private String nodeName;

    private String path;

    private Integer parentId;

    private Boolean hasChild;

    private Integer type;

    private Integer orderId;

    private Boolean actived;

    private Boolean deleted;

    public static final class Builder {
        private Integer tableId;
        private String nodeName;
        private String path;
        private Integer parentId;
        private Boolean hasChild;
        private Integer type;
        private Integer orderId;
        private Boolean actived;
        private Boolean deleted;

        private Builder() {
        }

        public static Builder aPermission() {
            return new Builder();
        }

        public Builder withTableId(Integer tableId) {
            this.tableId = tableId;
            return this;
        }

        public Builder withNodeName(String nodeName) {
            this.nodeName = nodeName;
            return this;
        }

        public Builder withPath(String path) {
            this.path = path;
            return this;
        }

        public Builder withParentId(Integer parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder withHasChild(Boolean hasChild) {
            this.hasChild = hasChild;
            return this;
        }

        public Builder withType(Integer type) {
            this.type = type;
            return this;
        }

        public Builder withOrderId(Integer orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder withActived(Boolean actived) {
            this.actived = actived;
            return this;
        }

        public Builder withDeleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Permission build() {
            Permission permission = new Permission();
            permission.setTableId(tableId);
            permission.setNodeName(nodeName);
            permission.setPath(path);
            permission.setParentId(parentId);
            permission.setHasChild(hasChild);
            permission.setType(type);
            permission.setOrderId(orderId);
            permission.setActived(actived);
            permission.setDeleted(deleted);
            return permission;
        }
    }
}