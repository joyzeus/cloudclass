package com.igeek.admin.service.impl;

import com.igeek.admin.config.jwt.JWTUtils;
import com.igeek.admin.config.redis.RedisUtil;
import com.igeek.admin.constant.RedisKeyEnum;
import com.igeek.admin.service.base.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/04/10
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    private static final long DEFAULT_EXPIRE_TIME = 24 * 60 * 60L;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public String createSaveToken(Long userId) {
        String token = jwtUtils.createToken(userId, DEFAULT_EXPIRE_TIME);
        redisUtil.set(RedisKeyEnum.TOKEN.getKey() + userId, token, DEFAULT_EXPIRE_TIME);
        return token;
    }

    @Override
    public boolean logout(Integer userId) {
        String key = RedisKeyEnum.TOKEN.getKey() + userId;
        if (redisUtil.has(key)) {
            return redisUtil.delete(key);
        }
        return false;
    }
}
