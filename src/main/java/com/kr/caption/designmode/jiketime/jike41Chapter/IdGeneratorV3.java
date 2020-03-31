package com.kr.caption.designmode.jiketime.jike41Chapter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式不支持延迟加载，懒汉式有性能问题，不支持高并发。那我们再来看一种既支持延迟
 * 加载、又支持高并发的单例实现方式
 * 只要 instance 被创建之后，即便再调用 getInstance() 函数也不会再进入到加锁逻辑中了
 */
public class IdGeneratorV3 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorV3 instance;
    private IdGeneratorV3() {
    }
    public static IdGeneratorV3 getInstance() {
        if (instance == null) {
            synchronized (IdGeneratorV3.class) {
                if (instance == null) {
                    instance = new IdGeneratorV3();
                }
            }
        }
        return instance;
    }
    public long getId() {
        return id.incrementAndGet();
    }
}
