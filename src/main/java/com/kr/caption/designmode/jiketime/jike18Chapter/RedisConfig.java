package com.kr.caption.designmode.jiketime.jike18Chapter;

import java.util.Map;

public class RedisConfig implements Updater, Viewer{

    private ConfigSource configSource; // 配置中心(比如 zookeeper)
    private String address;
    private int timeout;
    private int maxTotal;
    // 省略其他配置: maxWaitMillis,maxIdle,minIdle...

    public RedisConfig(ConfigSource configSource) {
        this.configSource = configSource;
    }

    public String getAddress() {
        return this.address;
    }

    //... 省略其他 get()、init() 方法...
    public void update() {
        // 从 configSource 加载配置到 address/timeout/maxTotal...
    }

    @Override
    public String outputInPlainText() {
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
    }
}
