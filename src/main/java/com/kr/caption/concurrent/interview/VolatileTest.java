package com.kr.caption.concurrent.interview;

import java.util.concurrent.TimeUnit;


/**
 *  flag 存放于主内存中，所以主线程和线程 A 都可以看到
 *
 *  用主线程关闭 A 线程
 */
public class VolatileTest implements Runnable {

    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "正在运行。。。");
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(volatileTest, "A").start();

        System.out.println("main 线程正在运行") ;

        TimeUnit.SECONDS.sleep(5);

        volatileTest.stopThread();

    }

    private void stopThread(){
        flag = false ;
    }
}
