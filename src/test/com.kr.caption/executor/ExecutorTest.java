package com.kr.caption.executor;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorTest {


    @Test
    public void test(){
        AtomicInteger runningCount = new AtomicInteger();

        runningCount.set(10);

        System.out.println(runningCount.compareAndSet(0, 1));

    }



}
