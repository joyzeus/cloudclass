package com.jay.book.module.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class ExceptionLog implements Serializable {
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "类名")
    private String className;

    @ApiModelProperty(value = "方法名")
    private String methodName;

    @ApiModelProperty(value = "异常类型")
    private String exceptionType;

    @ApiModelProperty(value = "远程访问主机IP")
    private String ip;

    @ApiModelProperty(value = "产生人id")
    private Integer createUserid;

    @ApiModelProperty(value = "异常发生时间")
    private Date addtime;

    @ApiModelProperty(value = "是否查看，1：未查看、2：已查看")
    private Byte view;

    @ApiModelProperty(value = "查看时间")
    private Date viewTime;

    @ApiModelProperty(value = "查看人id")
    private Integer viewUserid;

    @ApiModelProperty(value = "是否解决")
    private Boolean resolve;

    @ApiModelProperty(value = "解决时间")
    private Date resolveTime;

    @ApiModelProperty(value = "解决人id")
    private Integer resolveUserid;

    @ApiModelProperty(value = "异常信息")
    private String exceptionMsg;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType == null ? null : exceptionType.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Byte getView() {
        return view;
    }

    public void setView(Byte view) {
        this.view = view;
    }

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }

    public Integer getViewUserid() {
        return viewUserid;
    }

    public void setViewUserid(Integer viewUserid) {
        this.viewUserid = viewUserid;
    }

    public Boolean getResolve() {
        return resolve;
    }

    public void setResolve(Boolean resolve) {
        this.resolve = resolve;
    }

    public Date getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(Date resolveTime) {
        this.resolveTime = resolveTime;
    }

    public Integer getResolveUserid() {
        return resolveUserid;
    }

    public void setResolveUserid(Integer resolveUserid) {
        this.resolveUserid = resolveUserid;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg == null ? null : exceptionMsg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", className=").append(className);
        sb.append(", methodName=").append(methodName);
        sb.append(", exceptionType=").append(exceptionType);
        sb.append(", ip=").append(ip);
        sb.append(", createUserid=").append(createUserid);
        sb.append(", addtime=").append(addtime);
        sb.append(", view=").append(view);
        sb.append(", viewTime=").append(viewTime);
        sb.append(", viewUserid=").append(viewUserid);
        sb.append(", resolve=").append(resolve);
        sb.append(", resolveTime=").append(resolveTime);
        sb.append(", resolveUserid=").append(resolveUserid);
        sb.append(", exceptionMsg=").append(exceptionMsg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}