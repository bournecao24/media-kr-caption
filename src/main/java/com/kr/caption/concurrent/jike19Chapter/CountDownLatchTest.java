package com.kr.caption.concurrent.jike19Chapter;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    private List<Order> pos;
    private List<Order> dos;

    private void everyDayTask() {
        boolean hasExceptionOrder = true; // 是否有异常订单
        // 创建 2 个线程的线程池
        Executor executor = Executors.newFixedThreadPool(2);
        while (hasExceptionOrder) {
            // 计数器初始化为 2
            CountDownLatch latch = new CountDownLatch(2);
            // 查询未对账订单
            executor.execute(() -> {
                pos = getPOrders();
                latch.countDown();// 对计数器减一
            });
            // 查询派送单
            executor.execute(() -> {
                dos = getPOrders();
                latch.countDown();// 对计数器减一
            });
            // 等待两个查询操作结束
            try {
                latch.await();//对计数器等于0等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 执行对账操作
            check(pos, dos);
            // 保存
            save();
        }
    }

    private List<Order> getPOrders() {
        return Collections.emptyList();
    }

    private List<Order> getDOrders() {
        return Collections.emptyList();
    }

    private void check(List<Order> pos, List<Order> dos) {
    }
    private void save(){}
}
