package com.kr.caption.concurrent.jike18Chapter;

import java.util.concurrent.locks.StampedLock;

public class Point {
    private int x, y;
    final StampedLock sl = new StampedLock();

    double distanceFromOrigin() {
        // 乐观读
        long stamp = sl.tryOptimisticRead();

        // 读入局部变量，读的过程中可能被修改
        int curX = x;
        int curY = y;

        // 判断执行读操作期间是否有写操作，如果存在，则 sl.validate(stamp) 返回 false
        if (!sl.validate(stamp)) {
            // 升级为悲观读锁，如果不这样做，就需要在一个循环里反复执行乐观读，直到执行乐观读操作的期间没有写操作(只有这样才能保证 x 和 y 的正确性和一致性)，而循环读会浪费大量的 CPU
            stamp = sl.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                // 释放悲观读锁
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(curX * curX + curY * curY);
    }
}
