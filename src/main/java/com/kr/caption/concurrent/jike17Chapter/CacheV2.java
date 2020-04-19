package com.kr.caption.concurrent.jike17Chapter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  按需加载，重要的点在于：为啥需要再次验证，原因是在高并发的场景下，有可能会有多线程竞争写锁。假设缓存是空的，没有缓存任何东西，
 *  如果此时有三个线程 T1、T2 和 T3 同时调用 get() 方法，并且参数 key 也是相同的。那么它们会同时执行到代码5处，但此时只有一个线程能够获得写锁，
 *  假设是线程 T1，线程 T1 获取写锁之 查询数据库并更新缓存，最终释放写锁。
 *  此时线程 T2 和 T3 会再有一个线程能够获取写锁，假设是 T2，如果不采用再次验证的方式，此时 T2 会再次查询数据库。T2 释放写锁之后，T3 也会再次查询一次数据库。
 *  而实际上线程 T1 已经把缓存的值设置好了，T2、T3 完全没有必要再次查询数据库。所以，再次验证的方式，能够避免高并发场景下重复查询数据的问题。
 * @param <K>
 * @param <V>
 */
public class CacheV2<K, V> {

    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    // 通过 rwl 创建了一把读锁和一把写锁。
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    // 读缓存需要用到读锁，读锁的使用和前面我们介绍的 Lock 的使用是相同的，都是 try{}finally{}这个编程范式。
    V get(K key) {
        V v = null;
        r.lock();
        try {
            v = m.get(key);
        } finally {
            r.unlock();
        }

        if(v != null){
            return v;
        }
        //如果缓存中不存在，查询数据库
        w.lock();
        try{
            // 再次验证
            v = m.get(key);
            if(v == null ){
                // 查询数据库
                v = v;
                m.put(key, v);
            }
        }finally {
            w.unlock();
        }
        return v;
    }

    V put(K key, V v) {
        w.lock();
        try {
            return m.put(key, v);
        } finally {
            w.unlock();
        }
    }
}
