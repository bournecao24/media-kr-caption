package com.kr.caption.designmode.jiketime.jike43Chapter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程内唯一
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);
    private static final ConcurrentHashMap<Long, IdGenerator> instances = new ConcurrentHashMap<>();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGenerator());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
