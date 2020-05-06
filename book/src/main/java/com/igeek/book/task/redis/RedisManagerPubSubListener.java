package com.igeek.book.task.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPubSub;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/30 15:58
 */
@Slf4j
public class RedisManagerPubSubListener extends JedisPubSub {
    @Override
    public void unsubscribe() {
        super.unsubscribe();
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
    }

    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
    }

    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
    }

    @Override
    public void punsubscribe() {
        super.punsubscribe();
    }

    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
    }

    @Override
    public void onMessage(String channel, String message) {
        log.info("onMessage: channel[{}], message[{}]", channel, message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        log.info("onPMessage: pattern[{}], channel[{}], message[{}]", pattern, channel, message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        log.info("onSubscribe: channel[{}], subscribedChannels[{}]", channel, subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        log.info("onPUnsubscribe: pattern[{}], subscribedChannels[{}]", pattern, subscribedChannels);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        log.info("onPSubscribe: pattern[{}], subscribedChannels[{}]", pattern, subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        log.info("channel:{} is been subscribed:{}", channel, subscribedChannels);
    }
}
