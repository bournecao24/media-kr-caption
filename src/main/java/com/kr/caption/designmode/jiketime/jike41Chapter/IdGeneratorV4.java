package com.kr.caption.designmode.jiketime.jike41Chapter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类，只有这个类被使用的时候才会加载，instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证
 */
public class IdGeneratorV4 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorV4 instance;
    private IdGeneratorV4() {
    }
    private static class SingletonHolder {
        private static final IdGeneratorV4 instance = new IdGeneratorV4();
    }
    public static synchronized IdGeneratorV4 getInstance() {
        return SingletonHolder.instance;
    }
    public long getId() {
        return id.incrementAndGet();
    }
}
