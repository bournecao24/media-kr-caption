package com.kr.caption.util.redis.standalone;

import com.kr.caption.util.redis.AbstractRedisBuilder;
import com.kr.caption.util.redis.RedisBuilder;
import redis.clients.jedis.JedisPool;

public class RedisStandaloneBuilder extends AbstractRedisBuilder<JedisPool> {

    private JedisPool jedisPool;

    private String host;
    private Integer port;
    private String password;
    private int database = RedisBuilder.DEFAULT_DATABASE; //缺省
    private String clientName;

    @Override
    public JedisPool builder() {
        if (host == null || port == null) {
            throw new IllegalArgumentException(" RedisStandaloneBuilder host or port is not null ");
        }

        //单例模式，加锁，避免多线程下多次调用这个方法，只可以调用一次，确保 jedisPool 有且只有一个
        synchronized (this) {
            if (jedisPool != null) {
                return jedisPool;
            }
            jedisPool = new JedisPool(getPoolConfig(), host, port, getConnectionTimeOut(), getSoTimeOut(), password, database, clientName);
        }
        return jedisPool;
    }

    @Override
    public void destory() {
        if (jedisPool != null) {
            jedisPool.close();
        }
    }


    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
