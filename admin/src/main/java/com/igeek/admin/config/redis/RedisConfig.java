package com.igeek.admin.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
@Configuration
public class RedisConfig {

    @Autowired(required = false)
    private LettuceConnectionFactory factory;

    @Bean
    public com.igeek.admin.config.redis.RedisTemplate<String, Object> redisTemplate() {
        factory.setShareNativeConnection(false);
        com.igeek.admin.config.redis.RedisTemplate<String, Object> redisTemplate = new com.igeek.admin.config.redis.RedisTemplate<>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    @Bean
    public ValueOperations<String, String> valueOperations(com.igeek.admin.config.redis.RedisTemplate redisTemplate) {
        return redisTemplate.opsForValue();
    }

    @Bean
    public HashOperations<String, String, String> hashOperations(com.igeek.admin.config.redis.RedisTemplate redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    public ListOperations<String, String> listOperations(com.igeek.admin.config.redis.RedisTemplate redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, String> setOperations(com.igeek.admin.config.redis.RedisTemplate redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String, String> zSetOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}
