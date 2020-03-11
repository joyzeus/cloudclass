package com.igeek.admin.config.redis;

import com.igeek.common.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * @author zhouxu
 * @date 2019/12/24
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private HashOperations<String, String, String> hashOperations;
    @Autowired
    private ListOperations<String, String> listOperations;
    @Autowired
    private SetOperations<String, String> setOperations;
    @Autowired
    private SetOperations<String, String> zSetOperations;

    private static final long DEFAULT_EXPIRE = 24 * 60 * 60L;
    private static final long NOT_EXPIRE = -1L;

    public void set(String key, Object value) {
        if (value != null) {
            valueOperations.set(key, JacksonUtil.toJson(value));
        }
    }

    public void set(String key, Object value, long expire) {
        if (value != null) {
            valueOperations.set(key, JacksonUtil.toJson(value));
            expire(key, expire);
        }
    }

    public void set(String key, Object value, int dbIndex) {
        if (value != null) {
            redisTemplate.setDbIndex(dbIndex);
            valueOperations.set(key, JacksonUtil.toJson(value));
        }
    }

    public void set(String key, Object value, long expire, int dbIndex) {
        if (value != null) {
            redisTemplate.setDbIndex(dbIndex);
            valueOperations.set(key, JacksonUtil.toJson(value));
            expire(key, expire);
        }
    }

    public String get(String key) {
        return valueOperations.get(key);
    }

    public <T> T get(String key, Class<T> clazz) {
        return JacksonUtil.parseToObject(get(key), clazz);
    }

    public <T> List<T> getList(String key, Class<T> clazz) {
        return JacksonUtil.parseToArray(get(key), clazz);
    }

    public boolean expire(String key) {
        return expire(key, DEFAULT_EXPIRE);
    }

    public boolean expire(String key, long expire) {
        try {
            if (expire > 0) {
                return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setHash(String key, String subKey, Object value) {
        hashOperations.put(key, subKey, JacksonUtil.toJson(value));
    }

    public void setHash(String key, String subKey, Object value, int dbIndex) {
        redisTemplate.setDbIndex(dbIndex);
        hashOperations.put(key, subKey, JacksonUtil.toJson(value));
    }

    public void setHash(String key, String subKey, Object value, long expire) {
        hashOperations.put(key, subKey, JacksonUtil.toJson(value));
        expire(key, expire);
    }

    public void setHash(String key, String subKey, Object value, long expire, int dbIndex) {
        redisTemplate.setDbIndex(dbIndex);
        hashOperations.put(key, subKey, JacksonUtil.toJson(value));
        expire(key, expire);
    }

    public <T> T getHash(String key, String subKey, Class<T> clazz) {
        return JacksonUtil.parseToObject(hashOperations.get(key, subKey), clazz);
    }

    public boolean has(String key) {
        return redisTemplate.hasKey(key);
    }

    public boolean has(String key, int dbIndex) {
        redisTemplate.setDbIndex(dbIndex);
        return has(key);
    }

    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public boolean delete(String key, int dbIndex) {
        redisTemplate.setDbIndex(dbIndex);
        return delete(key);
    }
}