package com.kr.caption.effective.effective79c;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableSet<E> extends ForwardingSet<E> {


    public ObservableSet(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public Boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

//    private void notifyElementAdded(E element) {
//        synchronized (observers) {
//            for (SetObserver<E> observer : observers)
//                observer.added(this, element);
//        }
//    }


    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementAdded(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element);
        // Calls notifyElementAdded
        return result;
    }


    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

//        set.addObserver((s, e) -> System.out.println(e));


        /**
         *   打印出数字 0 ~ 23 ，然后抛出 ConcurrentModificationException，企图在遍历列表的过程中，将 一个元素从列表中删除
         */
        set.addObserver(new SetObserver<Integer>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    s.removeObserver(this);
                }
            }
        });


        /**
         * 编写一个试图取消预订的观察者，但是不直接调用 removeObserver ，它用另一个线程的服务来完成。这个观察者使用了一个 executor service
         * 后台线程调用 s.removeObserver ，它企图锁定 observers，但它无法获得该锁，因为主线程已经有锁了。
         * 在这期间，主线程一直在等待后台线程来完成对观察者的 删除，这正是造成死锁的原因。
         */
//        set.addObserver(new SetObserver<Integer>() {
//            @Override
//            public void added(ObservableSet<Integer> s, Integer e) {
//                System.out.println(e);
//
//                if (e == 23) {
//                    ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//                    try {
//                        executorService.submit(() -> s.removeObserver(this)).get();
//                    } catch (InterruptedException | ExecutionException ex) {     //多重捕获
//                        throw new AssertionError(ex);
//                    } finally {
//                        executorService.shutdown();
//                    }
//                }
//
//            }
//        });


        /**
         * 在前面这两个例子中(异常和死锁)，我们都还算幸运。调用外来方法( added )时，同步区域( observers )所保护的资源处于一致的状态。
         * 假设当同步区域所保护的约束条件暂时无效时，你要从同步区域中调用一个外来方 法。由于 Java 程序设计语言中的锁是可重入的( reentrant )，这种调用不会死锁。
         * 就像在第一个例子中一样，它会产生一个异常，因为调用线程已经有这个锁了，因此当该线程试图再次获得该锁时会成功，尽管概念上不相关的另 一项操作正在该锁所保护的数据上进行着。
         * 这种失败的后果可能是灾难性的。从本质上来说，这个锁没有尽到它的职 责。可重入的锁简化了多线程的面向对象程序的构造，但是它们可能会将活性失败变成安全性失败。

         */


        for (int i = 0; i < 100; i++) {
            set.add(i);
        }


    }


    /**
     * 修改之后的
     * 幸运的是，通过将外来方法的调用移出同步的代码块来解决这个问题通常并不太困难。对于
     * notifyElementAdded 方法，这还涉及给 observers 列表拍张“快照”，然后没有锁也可以安全地遍历这个列表了。 经过这一修改，前两个例子运行起来便再也不会出现异常或者死锁了:
     *
     * 也就是说将 外来方法的调用移出同步的代码块  就好了，也就契合的本章的主题， 不可过度同步
     * @param element
     */

    // Alien method moved outside of synchronized block - open calls
    private void notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized (observers) {
            snapshot = new ArrayList<>(observers);
        }
        for (SetObserver<E> observer : snapshot) {
            observer.added(this, element);
        }
    }
}