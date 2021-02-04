package com.kr.caption.designmode.jiketime.jike82Chapter;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @Author: caozhenlong
 * @Date: 2021-02-03
 * @Description:
 */
public class Demo {


    public static void main(String[] args) {

        Cache<String, Integer> cache = CacheBuilder.newBuilder()
                .initialCapacity(100)
                .maximumSize(1000)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build();

        cache.put("key", 666666666);
        Object key = cache.getIfPresent("key");
        System.out.println(key);
    }
}
