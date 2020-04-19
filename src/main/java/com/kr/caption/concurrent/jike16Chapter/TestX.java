package com.kr.caption.concurrent.jike16Chapter;

import java.util.concurrent.Semaphore;

public class TestX {
    static int count;
    // 初始化信号量
    static final Semaphore s = new Semaphore(1);
    // 用信号量保证互斥
    static void addOne() throws InterruptedException {
        s.acquire();
        try {
            count += 1;
        } finally {
            s.release();
        }
    }
}
