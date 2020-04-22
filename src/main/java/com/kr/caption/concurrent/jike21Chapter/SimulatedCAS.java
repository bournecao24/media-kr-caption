package com.kr.caption.concurrent.jike21Chapter;

/**
 * CAS 这种无锁方案，完全没有加锁、解锁操作，即便 两个线程完全同时执行 addOne() 方法，也不会有线程被阻塞，所以相对于互斥锁方案来说，性能好了很多。
 */
public class SimulatedCAS {

    volatile int count;

    void addOne() {
        int newValue;
        do {
            newValue = count + 1; //1
        } while (count != cas(count, newValue));
    }

    synchronized int cas(int expect, int newValue) {
        // 读目前 count 的值
        int curValue = count;
        // 比较目前 count 值是否 == 期望值
        if (curValue == expect) {
            // 如果是，则更新 count 的值
            count = newValue;
        }
        // 返回写入前的值
        return curValue;
    }
}
