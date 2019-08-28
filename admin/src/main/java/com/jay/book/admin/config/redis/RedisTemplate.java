package com.jay.book.admin.config.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisTemplate<K, V> extends org.springframework.data.redis.core.RedisTemplate<K, V> {

    private static final int DEFAULT_DB_INDEX = 0;

    private ThreadLocal<Integer> dbIndex = ThreadLocal.withInitial(() -> DEFAULT_DB_INDEX);

    public void setDbIndex(Integer dbIndex) {
        this.dbIndex.set(dbIndex);
    }

    @Override
    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        try {
            Integer index = dbIndex.get();
            if (index != null) {
                if (connection instanceof LettuceConnectionFactory) {
                    if (((LettuceConnectionFactory) connection).getDatabase() != index) {
                        connection.select(index);
                    }
                } else {
                    connection.select(index);
                }
            } else {
                connection.select(DEFAULT_DB_INDEX);
            }
        } finally {
            dbIndex.remove();
        }
        return super.preProcessConnection(connection, existingConnection);
    }
}