package com.jay.book.admin.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;
/**
 * @author zhouxu
 * @date 2019/12/24
 */
public class AuthToken implements AuthenticationToken {

    private String token;

    public AuthToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
