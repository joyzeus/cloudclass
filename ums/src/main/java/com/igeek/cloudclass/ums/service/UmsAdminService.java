package com.igeek.cloudclass.ums.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/5/19
 */
public interface UmsAdminService extends UserDetailsService {

    /**
     * 登录
     *
     * @param username 用户名称
     * @param password 用户密码
     * @return  返回登录token
     */
    String login(String username, String password);
}
