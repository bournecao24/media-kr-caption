package com.kr.caption.concurrent.jike19Chapter;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    boolean hasExceptionOrder = true; // 是否有异常订单
    // 订单队列
    Vector<Order> pos;
    // 派送单队列
    Vector<Order> dos;
    // 执行回调的线程池
    Executor executor = Executors.newFixedThreadPool(1);

    //  CyclicBarrier 的计数器有自动重置的功能，当减到 0 的时候，会自动重置你设置的初始值
    final CyclicBarrier barrier = new CyclicBarrier(2, () -> {
        executor.execute(() -> check());
    });

    void check() {
        Order p = pos.remove(0);
        Order d = dos.remove(0);
        // 执行对账操作
        check(p, d);
        // 差异写入差异库
        save();
    }

    void checkAll() {
        // 循环查询订单库
        Thread T1 = new Thread(() -> {
            while (hasExceptionOrder) {
                // 查询订单库
                pos.add(getPOrders());
                // 等待
                try {
                    barrier.await(); // 将计数器减一
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        T1.start();
        // 循环查询运单库
        Thread T2 = new Thread(() -> {
            while (hasExceptionOrder) {
                // 查询运单库
                dos.add(getDOrders());
                // 等待
                try {
                    barrier.await();  // 将计数器减一
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        T2.start();
    }

    private Order getPOrders() {
        return new Order();
    }

    private Order getDOrders() {
        return new Order();
    }

    private void check(Order pos, Order dos) {
    }

    private void save() {
    }

}
