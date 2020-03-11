package com.igeek.admin.service.impl;

import com.google.code.kaptcha.Producer;
import com.igeek.admin.constant.RedisKeyEnum;
import com.igeek.admin.config.redis.RedisUtil;
import com.igeek.admin.service.base.VerificationCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    private static final long VERIFICATIONCODE_EXPIRETIME = 5 * 60L;

    private final Producer producer;

    private final RedisUtil redisUtil;

    @Autowired(required = false)
    public VerificationCodeServiceImpl(Producer producer, RedisUtil redisUtil) {
        this.producer = producer;
        this.redisUtil = redisUtil;
    }

    public BufferedImage creaeteImgge(String uuid) {
        String code = producer.createText();
        redisUtil.set(RedisKeyEnum.VERTIFICATIONCDOE.getKey() + uuid, code, VERIFICATIONCODE_EXPIRETIME);
        return producer.createImage(code);
    }

    @Override
    public Integer authVerificationCode(String uuid, String code) {
        String key = RedisKeyEnum.VERTIFICATIONCDOE.getKey() + uuid;
        if (redisUtil.has(key)) {
            String s = redisUtil.get(key);
            if (StringUtils.equals(s, code)) {
                redisUtil.delete(key);
                return 0;
            }
            return 2;
        }
        return 1;
    }
}
