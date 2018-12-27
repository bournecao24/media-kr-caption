package com.kr.caption.util.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public abstract class AbstractRedisBuilder<T> implements RedisBuilder<T> {

    private GenericObjectPoolConfig poolConfig;

    private int connectionTimeOut = RedisBuilder.DEFAULT_CONNECTION_TIMEOUT;

    private int soTimeOut = RedisBuilder.DEFAULT_SO_TIMEOUT;

    public GenericObjectPoolConfig getPoolConfig() {
        if (poolConfig == null) {
            poolConfig = new GenericObjectPoolConfig();
            poolConfig.setMaxIdle(5);
            poolConfig.setMaxIdle(10);
            poolConfig.setMaxTotal(10);
            poolConfig.setTestOnBorrow(true); //向调用者输出链接的时候，是否检测是否有效
            poolConfig.setTestWhileIdle(true);//输出链接的时候，是否检测是否超时
        }

        return poolConfig;
    }

    public void setPoolConfig(GenericObjectPoolConfig poolConfig) {
        this.poolConfig = poolConfig;
    }

    public int getConnectionTimeOut() {
        return connectionTimeOut;
    }

    public void setConnectionTimeOut(int connectionTimeOut) {
        this.connectionTimeOut = connectionTimeOut;
    }

    public int getSoTimeOut() {
        return soTimeOut;
    }

    public void setSoTimeOut(int soTimeOut) {
        this.soTimeOut = soTimeOut;
    }
}
