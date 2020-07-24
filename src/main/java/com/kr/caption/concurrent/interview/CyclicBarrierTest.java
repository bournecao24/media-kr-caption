package com.kr.caption.concurrent.interview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CyclicBarrier;


/**
 * CyclicBarrier 中文名叫做屏障或者是栅栏，也可以用于线程间通信
 *
 * 可以等待 N 个线程都达到某个状态后继续运行的效果
 */
public class CyclicBarrierTest {

    private static final Logger logger = LogManager.getLogger(CyclicBarrierTest.class);

    private static void cyclicBarrier() throws Exception {

        //  首先初始化线程参与者
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("thread run");
                try {

                    // 调用 await() 将会在所有参与者线程都调用之前等待
                    // 直到所有参与者都调用了 await() 后，所有线程从 await() 返回继续后续逻辑
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                logger.info("thread end do something");

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("thread run");

                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                logger.info("thread end do something");

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("thread run");
                try {
                    Thread.sleep(5000);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                logger.info("thread end do something");
            }
        }).start();

        //  其中一个线程休眠了五秒，所有其余所有的线程都得等待这个线程调用 await()

        logger.info(" main end ");

    }

    public static void main(String[] args) throws Exception {
        cyclicBarrier();
    }


}
