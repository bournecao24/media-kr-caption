package com.kr.caption.concurrent.interview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 在 t1.join() 时会一直阻塞到 t1 执行完毕，所以最终主线程会等待 t1 和 t2 线程执行完毕
 */
public class ThreadOrderRun {
    private static final Logger logger = LogManager.getLogger(ThreadOrderRun.class);

    private static void join() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                logger.info("running 1");
                System.out.println("running 1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("running 2");
                System.out.println("running 2");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        // 等待线程1 完成
        t1.join();

        // 等待线程2 完成
        t2.join();


        System.out.println("完成");
    }

    public static void main(String[] args) {
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
