package com.kr.caption.util.redis;

public interface RedisBuilder<T> {

    public static final int DEFAULT_PORT = 6379;
    public static final int DEFAULT_SO_TIMEOUT = 2000;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 2000;
    public static final int DEFAULT_DATABASE = 0;

    public T builder();

    public void destory();

}
