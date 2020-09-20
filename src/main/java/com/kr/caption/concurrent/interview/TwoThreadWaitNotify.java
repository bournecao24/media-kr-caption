package com.kr.caption.concurrent.interview;


/**
 * 两个线程交替打印奇偶数：
 *
 * TwoThreadWaitNotify.class 对象完成了通信
 */
public class TwoThreadWaitNotify {

    private int start = 1;

    private boolean flag = false;

    /**
     * 偶数线程
     */
    public static class OuNum implements Runnable {
        private TwoThreadWaitNotify number;

        public OuNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {

            while (number.start <= 100) {
                //  对同一个对象 TwoThreadWaitNotify.class 获取锁
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("偶数线程抢到锁了");

                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "+-+偶数" + number.start);
                        number.start++;

                        number.flag = false;

                        // B 线程调用了 notify() 方法，这样 A 线程收到通知之后就可以从 wait() 方法中返回， 调用 notify() 方法会将等待队列中的线程移动到同步队列中，线程状态也会更新为 BLOCKED
                        TwoThreadWaitNotify.class.notify();

                    } else {
                        try {
                            // 调用了同步对象的 wait() 方法释放了锁并进入 WAITING 状态, 该线程也会被移动到等待队列中
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    /**
     * 奇数线程
     */
    public static class JiNum implements Runnable {
        private TwoThreadWaitNotify number;

        public JiNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {

            while (number.start <= 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("奇数线程抢到锁了");

                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + "+-+奇数" + number.start);
                        number.start++;

                        number.flag = true;

                        TwoThreadWaitNotify.class.notify();

                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }


    public static void main(String[] args) {
        TwoThreadWaitNotify waitNotify = new TwoThreadWaitNotify();

        Thread Athread = new Thread(new OuNum(waitNotify));
        Athread.setName("A");

        Thread Bthread = new Thread(new JiNum(waitNotify));
        Bthread.setName("B");

        Athread.start();
        Bthread.start();
    }


}
