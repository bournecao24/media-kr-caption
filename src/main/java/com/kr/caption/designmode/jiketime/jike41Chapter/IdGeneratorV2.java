package com.kr.caption.designmode.jiketime.jike41Chapter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式：支持延迟加载，缺点就是给 getInstance 方法加了锁，导致这个函数的并发度很低
 * 如果这个方法被频繁的用到，频繁加锁、释放锁及并发度低等问题，就会导致性能瓶颈
 */
public class IdGeneratorV2 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorV2 instance;
    private IdGeneratorV2() {
    }

    public static synchronized IdGeneratorV2 getInstance() {
        if (instance == null) {
            instance = new IdGeneratorV2();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
