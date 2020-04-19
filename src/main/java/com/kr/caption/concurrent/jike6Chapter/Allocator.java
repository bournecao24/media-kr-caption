package com.kr.caption.concurrent.jike6Chapter;

import java.util.ArrayList;
import java.util.List;

public class Allocator {

    private List<Object> als = new ArrayList<>();

    // 一次性申请所有资源
    synchronized boolean apply(Object from, Object to) {
        if (!als.contains(from) || !als.contains(to)) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        als.add(from);
        als.add(to);

        return true;
    }

    // 归还资源
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);

        notifyAll();
    }


    private void test() {
        Thread th = Thread.currentThread();
        while (true) {
            if (th.isInterrupted()) {
                break;
            }
        // 省略业务代码无数...
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
