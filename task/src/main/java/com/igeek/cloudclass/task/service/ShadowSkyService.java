package com.igeek.cloudclass.task.service;

public interface ShadowSkyService {

    /**
     * 登录shadowsky 账号
     *
     * @param account  账号
     * @param password 密码
     * @return 登录结果
     */
    String login(String account, String password);

    /**
     * shadowsky 签到
     *
     * @param token 用户token
     * @return 签到结果
     */
    String signIn(String token);
}
