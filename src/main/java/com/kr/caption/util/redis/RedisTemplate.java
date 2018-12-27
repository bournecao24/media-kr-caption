package com.kr.caption.util.redis;

public interface RedisTemplate {
    public void setRedisBuilder(RedisBuilder<?> builder);

    public <T> T execute(RedisCallback<?, T> callback);
}
