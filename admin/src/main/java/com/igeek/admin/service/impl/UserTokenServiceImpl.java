package com.igeek.admin.service.impl;

import com.igeek.common.util.TokenGenerator;
import com.igeek.admin.config.redis.RedisUtil;
import com.igeek.admin.constant.RedisKeyEnum;
import com.igeek.admin.service.base.UserTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImpl implements UserTokenService {

    private static final long DEFAULT_EXPIRE_TIME = 24 * 60 * 60L;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String createSaveToken(Integer userId) {
        String token = TokenGenerator.createToken();
        redisUtil.set(RedisKeyEnum.TOKEN.getKey() + userId, token, DEFAULT_EXPIRE_TIME);
        redisUtil.set(RedisKeyEnum.USERID.getKey() + token, userId, DEFAULT_EXPIRE_TIME);
        return token;
    }

    @Override
    public boolean logout(Integer userId) {
        String key = RedisKeyEnum.TOKEN.getKey() + userId;
        if (redisUtil.has(key)) {
            String token = redisUtil.get(key, String.class);
            String tokenKey = RedisKeyEnum.USERID.getKey() + token;
            if (StringUtils.isNotEmpty(tokenKey) && redisUtil.has(tokenKey)) {
                redisUtil.delete(tokenKey);
            }
            return redisUtil.delete(key);
        }
        return false;
    }
}
