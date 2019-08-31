package com.jay.book.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class ExceptionLog implements Serializable {
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