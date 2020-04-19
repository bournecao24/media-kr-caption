//package com.kr.caption.concurrent.jike14Chapter;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//
///**
// * 如何利用两个条件变量快速实现阻塞队列呢?
// * @param <T>
// */
//public class BlockedQueue<T> {
//    final Lock lock = new ReentrantLock();
//    // 条件变量:队列不满
//    final Condition notFull = lock.newCondition();
//    // 条件变量:队列不空
//    final Condition notEmpty = lock.newCondition();
//    void enq(T x) {
//        lock.lock();
//        try {
//            while (/**队列已满**/) {
//                // 等待队列不满
//                notFull.await();
//            }
//            // 省略入队操作...
//            // 入队后, 通知可出队
//            notEmpty.signal();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//    //出队
//    void deq() {
//        lock.lock();
//        try {
//            while (/**队列已空**/) {
//                // 等待队列不空
//                notEmpty.await();
//            }
//            // 省略出队操作...
//            // 出队后，通知可入队
//            notFull.signal();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//}
