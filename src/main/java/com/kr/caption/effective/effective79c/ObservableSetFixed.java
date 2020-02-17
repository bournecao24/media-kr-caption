package com.kr.caption.effective.effective79c;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 事实上，要将外来方法的调用移出同步的代码块，还有一种更好的方法。Java 类库提供了一个并发集合( concurrent collection )，详见第 81 条，称作 CopyOnWriteArrayList ，这是专门为此定制的。
 * 这个 CopyOnWriteArrayList 是 ArrayList 的一种变体，它通过重新拷贝整个底层数组，在这里实现所有的写操作。 由于内部数组永远不改动，因此迭代不需要锁定，速度也非常快。
 * 如果大量使用， CopyOnWriteArrayList 的性能 将大受影响，但是对于观察者列表来说却是很好的，因为它们几乎不改动，并且经常被遍历。
 * 如果将这个列表改成使用 CopyOnWriteArrayList ，就不必改动 ObservableSet 的 add 和 addAll 方法。 下面是这个类的其余代码。注意其中并没有任何显式的同步:
 * @param <E>
 */
public class ObservableSetFixed<E> extends ForwardingSet<E> {

    public ObservableSetFixed(Set<E> set) {
        super(set);
    }

    // Thread-safe observable set with CopyOnWriteArrayList
    private final List<SetObserverFixed<E>> observers = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserverFixed<E> observer) {
        observers.add(observer);
    }

    public Boolean removeObserver(SetObserverFixed<E> observer) {
        return observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for (SetObserverFixed<E> observer : observers) {
            observer.added(this, element);
        }
    }


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
        ObservableSetFixed<Integer> set = new ObservableSetFixed<>(new HashSet<>());

//        set.addObserver((s, e) -> System.out.println(e));


        /**
         *   打印出数字 0 ~ 23 ，然后抛出 ConcurrentModificationException，企图在遍历列表的过程中，将 一个元素从列表中删除
         */
        set.addObserver(new SetObserverFixed<Integer>() {
            public void added(ObservableSetFixed<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    s.removeObserver(this);
                }
            }
        });


//        set.addObserver(new SetObserver<Integer>() {
//            @Override
//            public void added(ObservableSetFixed<Integer> s, Integer e) {
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


        for (int i = 0; i < 100; i++) {
            set.add(i);
        }


    }


}