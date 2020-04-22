package com.kr.caption.concurrent.jike22Chapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 简化的线程池，仅用来说明工作原理
 */
public class MyThreadPool {
    //利用阻塞队列实现生产者-消费者模式
    BlockingQueue<Runnable> workQueue;
    //保存内部工作线程
    List<WorkerThread> threads = new ArrayList<>();

    // 构造方法
    MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        // 创建工作线程
        for (int idx = 0; idx < poolSize; idx++) {
            WorkerThread work = new WorkerThread();
            work.start();
            threads.add(work);
        }
    }

    // 提交任务，execute()方法的内部实现仅仅 是将任务加入到workQueue中
    void execute(Runnable command) throws InterruptedException {
        workQueue.put(command);
    }

    // 工作线程负责消费任务，并执行任务
    class WorkerThread extends Thread {
        public void run() {
            //循环取任务并执行, MyThreadPool内部维护的工作线程会消费workQueue中的任务并执行任务
            while (true) {
                Runnable task = null;
                try {
                    task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        MyThreadPool pool = new MyThreadPool(5, workQueue);
        pool.execute(() -> {
            System.out.println(" Hello My Pool");
        });
    }
}