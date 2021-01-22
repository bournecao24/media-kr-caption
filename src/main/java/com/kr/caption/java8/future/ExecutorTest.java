package com.kr.caption.java8.future;

import java.util.concurrent.*;


/**
 * 让你的线程可以在ExecutorService以并发方式调 用另一个线程执行耗时操作的同时，去执行一些其他的任务。
 */
public class ExecutorTest {


    private void test() {
        //创建 Executor- Service，通 过它你可以 向线程池提 交任务
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(new Callable<Double>() {    //向Executor- Service提交一个 Callable对象
            @Override
            public Double call() throws Exception {
                return doSomeLongComputation();
            }
        });

        //异步操作进行的同时你可以做其他的事情
        doSomethingElse();

        try {
            future.get(1, TimeUnit.SECONDS);   //获取异步操作的结果，如果最终被 阻塞，无法得到结果，那么在最多等待1秒钟之后退出
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


    private double doSomeLongComputation() {
        return 0D;
    }

    void doSomethingElse() {

    }
}
