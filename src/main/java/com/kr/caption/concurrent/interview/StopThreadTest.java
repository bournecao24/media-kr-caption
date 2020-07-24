package com.kr.caption.concurrent.interview;

import java.util.concurrent.TimeUnit;


/**
 *  可以采用中断线程的方式来通信
 *
 *  调用了 thread.interrupt() 方法其实就是将 thread 中的一个标志属性置为了 true
 *
 *  并不是说调用了该方法就可以中断线程，如果不对这个标志进行响应其实是没有什么作用(这里对这个标志进行了判断)
 *
 *  但是如果抛出了 InterruptedException 异常，该标志就会被 JVM 重置为 false
 */
public class StopThreadTest implements Runnable{


    @Override
    public void run() {

        while (! Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName() + " 该线程正在运行");
        }

        System.out.println(Thread.currentThread().getName() + " 该线程结束运行");
    }


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new StopThreadTest(), "thread A");
        thread.start();

        System.out.println("main 线程正在运行") ;

        TimeUnit.MILLISECONDS.sleep(10) ;

        thread.interrupt();
    }
}
