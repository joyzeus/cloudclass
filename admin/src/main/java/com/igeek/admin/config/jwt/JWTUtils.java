package com.igeek.admin.config.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/10 9:56
 */
@Component
public class JWTUtils {

    @Autowired
    TokenConfig tokenConfig;

    public String createToken(Long userId, Long expireTime) {
        DefaultJwtBuilder builder = new DefaultJwtBuilder();

        //1.头部
        builder.setHeaderParam("alg", "HS256");
        builder.setHeaderParam("typ", "JWT");

        //2.个人信息
        DefaultClaims claims = new DefaultClaims();
        claims.setId(String.valueOf(userId));
        claims.setIssuedAt(new Date());
        claims.setExpiration(new Date(System.currentTimeMillis() + expireTime));
        builder.setClaims(claims);

        //3.签名
        builder.signWith(SignatureAlgorithm.HS256, tokenConfig.getSecret());
        return builder.compact();
    }
}
