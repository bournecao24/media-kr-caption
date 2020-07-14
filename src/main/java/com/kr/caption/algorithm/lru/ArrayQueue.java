package com.kr.caption.algorithm.lru;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 阻塞队列
 *
 * @param <T>
 */
public class ArrayQueue<T> {
    private static Logger logger = LogManager.getLogger(ArrayQueue.class);


    public int count = 0;

    private Object[] items;


    /**
     * 队列满时的阻塞锁
     */
    private Object full = new Object();


    /**
     * 队列空时的阻塞锁
     */
    private Object empty = new Object();


    private int putIndex;

    private int getIndex;

    public ArrayQueue(int size) {
        this.items = new Object[size];
    }


    /**
     * 从队列尾部写入
     * 条件：
     * 1、队列满的时候，写入的线程需要被阻塞：Thread.sleep(timeout)线程休眠（不合适，它在到达超时时间之后便会继续运行；达不到空间可用时才唤醒继续运行这个特点）； object.wait() 让线程进入 waiting 状态
     * <p>
     * <p>
     * 2、写入过队列的数量大于队列大小时需要从第一个下标开始写
     * <p>
     * 这里的 wait 和 notify 操作都需要对各自的对象使用 synchronized 方法块，这是因为 wait 和 notify 都需要获取到各自的锁
     *
     * @param t
     */
    public void put(T t) {
        synchronized (full) {
            while (count == items.length) {
                try {
                    full.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

        synchronized (empty) {
            items[putIndex] = t;
            count++;

            putIndex++;
            if (putIndex == items.length) {
                putIndex = 0;
            }

            empty.notify();
        }
    }


    /**
     * 写入队列满时会阻塞直到获取线程消费了队列数据后唤醒写入线程。
     * <p>
     * 消费队列空时会阻塞直到写入线程写入了队列数据后唤醒消费线程
     *
     * @return
     */
    public T get() {
        synchronized (empty) {
            while (count == 0) {
                try {
                    empty.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }
        }

        synchronized (full) {
            Object result = items[getIndex];
            items[getIndex] = null;
            count--;

            getIndex++;
            if (getIndex == items.length) {
                getIndex = 0;
            }

            full.notify();

            return (T) result;

        }
    }



//    public static void main(String[] args) {
//        ArrayQueue<String> queue = new ArrayQueue(4);
//
//        queue.put("1");
//        queue.put("12");
//        queue.put("123");
//        queue.put("1234");
//        System.out.println(queue.count);
//        while (queue.count > 0){
//            System.out.println(queue.get());
//        }
//    }

    public static void main(String[] args) {
        final ArrayQueue<String> queue = new ArrayQueue(4);

        new Thread(() -> {

            try {
                logger.info("{" + Thread.currentThread().getName() + "}" + queue.get());
            }catch (Exception e){
            }
        }).start();

        queue.put("1");
        queue.put("12");
        queue.put("123");
        queue.put("1234");

        logger.info("size={}", queue.count);

        while (queue.count > 0){
            logger.info(queue.get());
        }
    }


}
