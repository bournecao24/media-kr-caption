package com.kr.caption.concurrent.jike1Chapter;

/**
 * 假设线程 A 和线程 B 同时开始执行，那么第一次都会将 count=0 读到各自的 CPU 缓存里，执行完 count+=1 之后，各自 CPU 缓存里的值都是 1，同时写入内存后，
 * 我们会发现内存中是 1，而不是我们期望的 2。之后由于各自的 CPU 缓存里都有了 count 的 值，两个线程都是基于 CPU 缓存里的 count 值来计算，所以导致最终 count 的值都是小 于 20000 的。
 * 这就是缓存的可见性问题。
 */
public class Test {
    private static long count = 0;
    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }
    public static long calc() {
        final Test test = new Test();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}
