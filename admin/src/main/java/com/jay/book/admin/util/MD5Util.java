package com.jay.book.admin.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {

    public static String encode(String source) {
        if (source == null) {
            throw new RuntimeException("加密数据不能为空");
        }
        byte[] secretBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            secretBytes = md.digest();
        } catch (Exception e) {
            throw new RuntimeException("获取MD加密方式失败");
        }

        StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));// 16进制数字
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code.insert(0, "0");
        }
        return md5code.toString();
    }
}
