package com.kr.caption.effective.effective79c;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;


/**
 * 作用：给一个动作的并发执行定时
 * 所有的工作线程( worker thread )自身都 准备好，要在 timer 线程启动时钟之前运行该动作。
 * 当最后一个工作线程准备好运行该动作时， timer 线程就「发射 发令枪(fires the starting gun)」，同时允许工作线程执行该动作。
 * 一旦最后一个工作线程执行完该动作，timer 线程就立即停止计时。
 */
public class ConcurrentTime {

    // Simple framework for timing concurrent execution
    /**
     * 这个方法使用了三个倒计数锁存器。第一个是 ready ，工作线程用它来告诉线程它们已经准备好了。
     * 然后工作线程在第二个锁存器 start 上等待。
     * 当最后一个工作线程调用 ready.countDown 时， timer 线程记录下起始时间，并调用 start.countDown 允许所有的工作线程继续进行。
     * 然后 timer 线程在第三个锁存器 done 上等待，直到最后一个工作线程运行完该动作，并调用 done.countDown 。
     * 一旦调用这个， timer 线程就会苏醒过来，并记录下结束的时间。
     *
     * @param executor    一个执行该动作的 executor
     * @param concurrency 一个并发 级别(表示要并发执行该动作的次数)
     * @param action      该动作的 runnable
     * @return
     * @throws InterruptedException
     */
    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown();
            // Tell timer we're ready
                try {
                    start.await();
            // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
            // Tell timer we're done
                }
            });
        }
        ready.await();
            // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown();
            // And they're off!
        done.await();
            // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }
}
