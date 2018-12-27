package com.kr.caption.util.redis.standalone;

import com.kr.caption.util.redis.RedisBuilder;
import com.kr.caption.util.redis.RedisCallback;
import com.kr.caption.util.redis.RedisTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;

public class RedisStandaloneTemplate implements RedisTemplate {

    private final static Logger logger = LogManager.getLogger(RedisStandaloneTemplate.class);

    private RedisStandaloneBuilder builder;

    @Override
    public void setRedisBuilder(RedisBuilder<?> builder) {
        if (builder instanceof RedisStandaloneBuilder) {
            this.builder = ((RedisStandaloneBuilder) builder);
            return;
        }

        throw new IllegalArgumentException("RedisStandaloneTemplate setRedisBuilder参数类型错误");
    }

    @Override
    public <T> T execute(RedisCallback<?, T> callback) {

        if (!(callback instanceof RedisStandaloneCallback)) {
            throw new IllegalArgumentException();
        }

        Jedis jedis = null;
        try {
            jedis = builder.builder().getResource();
            return ((RedisStandaloneCallback<T>) callback).doCallback(jedis);
        } catch (Exception e) {
            logger.error("RedisStandaloneTemplate execute error:", e);
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }


    public String get(final String key) {
        return execute(new RedisStandaloneCallback<String>() {
            @Override
            public String doCallback(Jedis jedis) {
                return jedis.get(key);
            }
        });
    }

    public boolean set(final String key, final String value) {
        return execute(new RedisStandaloneCallback<Boolean>() {
            @Override
            public Boolean doCallback(Jedis jedis) {
                jedis.set(key, value);
                return true;
            }
        });
    }

    public boolean setWithExpire(final String key, final String value, final int seconds){
        return execute(new RedisStandaloneCallback<Boolean>() {
            @Override
            public Boolean doCallback(Jedis jedis) {
                jedis.set(key,value);
                jedis.expire(key, seconds);
                return true;
            }
        });
    }

    public String hget(final String key, final String field){
        return execute(new RedisStandaloneCallback<String>() {
            @Override
            public String doCallback(Jedis jedis) {
                return jedis.hget(key, field);
            }
        });
    }

    public boolean hset(final String key, final String field, final String fieldValue){
        return execute(new RedisStandaloneCallback<Boolean>() {
            @Override
            public Boolean doCallback(Jedis jedis) {
                jedis.hset(key, field, fieldValue);
                return true;
            }
        });
    }
}
