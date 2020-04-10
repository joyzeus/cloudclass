package com.igeek.admin.config.jwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/10 10:05
 */
@Configuration
@Data
public class TokenConfig {

    @Value("${token.secret}")
    String secret;
    @Value("${token.expiration}")
    Long expiration;
}
