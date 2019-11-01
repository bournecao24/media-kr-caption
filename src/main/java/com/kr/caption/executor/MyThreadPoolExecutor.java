package com.kr.caption.executor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 */
public class MyThreadPoolExecutor implements Executor {


    private String name;

    //核心线程数量
    private int coreSize;

    private int maxSize;

    //
    private BlockingDeque<Runnable> taskQueue;

    private RejectPolicy rejectPolicy;

    private static AtomicInteger runningCount = new AtomicInteger();


    public MyThreadPoolExecutor(String name, int coreSize, int maxSize, BlockingDeque<Runnable> taskQueue, RejectPolicy rejectPolicy) {
        this.name = name;
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.taskQueue = taskQueue;
        this.rejectPolicy = rejectPolicy;
    }

    @Override
    public void execute(Runnable command) {


    }

    private boolean addWorker(Runnable newTask, boolean core){

        for (;;){

            int count = runningCount.get();

            int max = core ? coreSize : maxSize;

            if(count >= max){
                return false;
            }

            if(runningCount.compareAndSet(count, count+1)){

                String threadName = (core?"core_" : "") + name ;

//                new Thread(() -> {
//                    System.out.println("thread name : " + Thread.currentThread().getName());
//
//
//
//
//
//                }),



            }

        }





    }
}
