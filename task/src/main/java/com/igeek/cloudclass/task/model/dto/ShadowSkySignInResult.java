package com.igeek.cloudclass.task.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class ShadowSkySignInResult implements Serializable {

    public ShadowSkySignInResult() {
    }

    public ShadowSkySignInResult(Integer ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }

    private Integer ret;
    private String msg;
}
