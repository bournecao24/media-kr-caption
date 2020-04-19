package com.kr.caption.concurrent.jike16Chapter;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 用一个 List来保存对象实例，用 Semaphore 实现限流器
 * @param <T>
 * @param <R>
 */
public class ObjPool<T, R> {
    final List<T> pool;
    final Semaphore sem;

    public ObjPool(int size, T t) {
        pool = new Vector<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    /**
     * 首先调用 acquire() 方法，假设对象池的大小是 10，信号量的计数器初始化为 10，那么前 10 个线程调用 acquire() 方法，都能继续执行，相当于通过了信号灯， 而其他线程则会阻塞在 acquire() 方法上。
     * @param func
     * @return
     */
    R exec(Function<T, R> func) {
        T t = null;
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            // 对于通过信号灯的线程，我们为每个线程分配了一个对象 t(这个分配工作是通过 pool.remove(0) 实现的)，分配完之后会执行一个回调函数 func，而函数的参数正是前面分配的对象 t
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            // 执行完回调函数之后，它们就会释放对象(这个释放工作是通过 pool.add(t) 实现的)，同时调用 release() 方法来更新信号量的计数器。如果此时信号量里计数器的值小于等于 0，那么说明有线程在等待，此时会自动唤醒等待的线程。
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) {
        ObjPool<Long, String> objPool = new ObjPool<Long, String>(10, (long) 2);
        objPool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }
}