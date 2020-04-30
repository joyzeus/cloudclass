package com.igeek.common.util;

import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 *
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/1/2 15:53
 */
@Data
public class DistributedLock {

    private static final TimeUnit DEFAULT_UNIT = TimeUnit.SECONDS;
    private static final long DEFAULT_EXPIRE = 5L;
    private static final String DEFAULT_PREFIX = "sys:distributed:lock:";
    private static final String REDIS_SUCCESS_STRING = "OK";

    private RedisTemplate redisTemplate;

    private String key;

    private long expire = DEFAULT_EXPIRE;

    private TimeUnit unit = DEFAULT_UNIT;

    private String value;

    public DistributedLock(RedisTemplate redisTemplate, String key, String value) {
        this.redisTemplate = redisTemplate;
        this.key = key;
        this.value = value;
    }

    public boolean tryLock() {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return 'OK' else return redis.call('set', KEYS[1], ARGV[1],'EX',ARGV[2],'NX') end";
        String result = (String) redisTemplate.execute(RedisScript.of(script, String.class), Collections.singletonList(getKey()), this.value, this.unit.toSeconds(this.expire) + "");
        return REDIS_SUCCESS_STRING.equals(result);
    }

    public boolean tryLock(long timeout, TimeUnit unit) {
        long during = unit.toMicros(timeout);
        long start = System.currentTimeMillis();
        while (true) {
            if (tryLock()) {
                return true;
            }
            long end = System.currentTimeMillis();
            if (end - start >= during) {
                break;
            }
        }
        return false;
    }

    public boolean release() {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then redis.call('del', KEYS[1]) return 1 else return 0 end";
        Long result = (Long) redisTemplate.execute(RedisScript.of(script, Long.class), Collections.singletonList(getKey()), this.value);
        return result != null && result > 0;
    }

    private String getKey() {
        return DEFAULT_PREFIX + this.key;
    }
}
