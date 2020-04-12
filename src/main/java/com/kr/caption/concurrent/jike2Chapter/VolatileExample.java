package com.kr.caption.concurrent.jike2Chapter;

public class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }
    public void reader() {
        if (v == true) {
    // 这里 x 会是多少呢?
        }
    }
}