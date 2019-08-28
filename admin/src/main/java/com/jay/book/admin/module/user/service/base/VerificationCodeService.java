package com.jay.book.admin.module.user.service.base;

import java.awt.image.BufferedImage;

public interface VerificationCodeService {

    /**
     * 获取验证码
     *
     * @param uuid uuid
     * @return 验证码
     */
    BufferedImage creaeteImgge(String uuid);

    /**
     * 验证验证码是否有效
     *
     * @param uuid uuid
     * @param code 验证码
     * @return 是否有效
     */
    Integer authVerificationCode(String uuid, String code);
}
