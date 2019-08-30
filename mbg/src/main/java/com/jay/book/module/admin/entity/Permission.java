package com.jay.book.module.admin.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private Integer tableId;

    private String nodeName;

    private String path;

    private Integer parentId;

    private Byte hasChild;

    private Integer type;

    private Integer orderId;

    private Byte actived;

    private Byte deleted;

    private static final long serialVersionUID = 1L;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getHasChild() {
        return hasChild;
    }

    public void setHasChild(Byte hasChild) {
        this.hasChild = hasChild;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Byte getActived() {
        return actived;
    }

    public void setActived(Byte actived) {
        this.actived = actived;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableId=").append(tableId);
        sb.append(", nodeName=").append(nodeName);
        sb.append(", path=").append(path);
        sb.append(", parentId=").append(parentId);
        sb.append(", hasChild=").append(hasChild);
        sb.append(", type=").append(type);
        sb.append(", orderId=").append(orderId);
        sb.append(", actived=").append(actived);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}