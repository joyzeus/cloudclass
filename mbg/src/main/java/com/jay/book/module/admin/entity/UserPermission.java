package com.jay.book.module.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class UserPermission implements Serializable {
    private Integer tableId;

    @ApiModelProperty(value = "权限Id")
    private Integer relationId;

    @ApiModelProperty(value = "权限类型")
    private Integer type;

    @ApiModelProperty(value = "用户Id")
    private Integer userId;

    @ApiModelProperty(value = "权限有效期")
    private Date expiredTime;

    private static final long serialVersionUID = 1L;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableId=").append(tableId);
        sb.append(", relationId=").append(relationId);
        sb.append(", type=").append(type);
        sb.append(", userId=").append(userId);
        sb.append(", expiredTime=").append(expiredTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}