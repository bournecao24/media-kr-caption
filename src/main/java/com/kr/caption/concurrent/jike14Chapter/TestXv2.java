package com.kr.caption.concurrent.jike14Chapter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 当线程 T1 执行到 addOne 方法时，已经获取到了锁 rtl ，当在调用 get() 方法时，会再次对锁 rtl 执行加锁操作。
 * 此时，如果锁 rtl 是可重入的，那么线程 T1 可以再次加锁成功;如果锁 rtl 是不可重入的，那么线程 T1 此时会被阻塞。
 */
public class TestXv2 {
    private final Lock rtl = new ReentrantLock();
    int value;

    public int get() {
        // 获取锁
        rtl.lock();
        try {
            return value;
        } finally {
            rtl.unlock();
        }
    }

    public void addOne() {
        // 获取锁
        rtl.lock();
        try {
            value = 1 + get();
        } finally {
            rtl.unlock();
        }
    }
}

