package com.kr.caption.util.redis;

public interface RedisCallback<I,O> {

    public O doCallback(I Object);
}
