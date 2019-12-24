package com.jay.book.admin.config.redis;

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
    public RedisTemplate<String, Object> redisTemplate() {
        factory.setShareNativeConnection(false);
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    @Bean
    public ValueOperations<String, String> valueOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForValue();
    }

    @Bean
    public HashOperations<String, String, String> hashOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    public ListOperations<String, String> listOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, String> setOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String, String> zSetOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}
