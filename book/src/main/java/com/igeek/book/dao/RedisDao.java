package com.igeek.book.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/30 10:06
 */
@Component
public class RedisDao {

    private static final TimeUnit DEFAULT_TIMEUNIT = TimeUnit.SECONDS;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置某个key的值
     *
     * @param key   需要设置的key
     * @param value 设置的值
     * @return
     */
    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置Redis key 并设置过期时间
     *
     * @param key     需要设置的key
     * @param value   设置的值
     * @param timeout 过期时长
     * @return
     */
    public boolean setExpire(String key, String value, long timeout) {
        return setExpire(key, value, timeout, DEFAULT_TIMEUNIT);
    }


    /**
     * 设置Redis key 并设置过期时间
     *
     * @param key      需要设置的key
     * @param value    设置的值
     * @param timeout  过期时长
     * @param timeUnit 时间单位
     * @return
     */
    public boolean setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        boolean setResult = set(key, value);
        if (setResult) {
            return expire(key, timeout, timeUnit);
        }
        return false;
    }


    /**
     * 设置key 过期时间
     *
     * @param key     设置的key
     * @param timeout 过期时间
     * @return
     */
    public Boolean expire(String key, Long timeout) {
        return expire(key, timeout, DEFAULT_TIMEUNIT);
    }


    /**
     * 设置key 过期时间
     *
     * @param key      设置的key
     * @param timeout  过期时间
     * @param timeUnit 过期时间格式
     * @return
     */
    public Boolean expire(String key, Long timeout, TimeUnit timeUnit) {
        try {
            return redisTemplate.expire(key, timeout, timeUnit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取key的值
     *
     * @param key 需要获取的key
     * @return
     */
    public String get(String key) {
        try {
            Object o = redisTemplate.opsForValue().get(key);
            return o == null ? "" : o.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*-------------------------------------------------------- hash api ------------------------------------------------------------------*/

    public boolean putHash(String key, Object hashKey, String hashValue) {
        redisTemplate.opsForHash().put(key, hashKey, hashValue);
        return true;
    }

    public boolean putHash(String key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
        return true;
    }

    public Object getHash(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    public Map<Object, Object> getHashEntries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public long deleteHash(String key, Object... hashKey) {
        return redisTemplate.opsForHash().delete(key, hashKey);
    }

    public Boolean hasHashKey(String key, Object hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }


    /*-------------------------------------------------------- list api ------------------------------------------------------------------*/

    public long rightPush(String key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    public Object leftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    public Object bLeftPop(String key) {
        return redisTemplate.opsForList().leftPop(key, 0, TimeUnit.SECONDS);
    }


    /*-------------------------------------------------------- set api ------------------------------------------------------------------*/



    /*-------------------------------------------------------- sorted set api ------------------------------------------------------------------*/

    public boolean addZSet(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    public Set<ZSetOperations.TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, start, end);
    }
}