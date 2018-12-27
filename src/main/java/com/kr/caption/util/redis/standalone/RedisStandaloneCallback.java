package com.kr.caption.util.redis.standalone;

import com.kr.caption.util.redis.RedisCallback;
import redis.clients.jedis.Jedis;

public interface RedisStandaloneCallback<O> extends RedisCallback<Jedis,O> {
    @Override
    public O doCallback(Jedis jedis);
}
