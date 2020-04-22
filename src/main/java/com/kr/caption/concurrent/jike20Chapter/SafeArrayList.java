package com.kr.caption.concurrent.jike20Chapter;

import java.util.*;

/**
 * 如何将非线程安全的容器变成线程安全的容器？
 * 思路：只要把非线程安全的容器封装在对象内部，然后控制好访问路径就可以了。
 * 举一反三：所有非线程安全的类是不是都可以用这种包装的方式来实现线程安全呢
 * @param <T>
 */
public class SafeArrayList<T> {
    List<T> c = new ArrayList<>();
    synchronized T get(int idx) {
        return c.get(idx);
    }
    synchronized void add(int idx, T t) {
        c.add(idx, t);
    }
    /**
     * 组合操作需要注意竞态条件问题，即便每个操作都能保证原子性，也并不能保证组合操作的原子性
     *
     * @param t
     * @return
     */
    synchronized boolean addIfNotExist(T t) {
        if (!c.contains(t)) {
            c.add(t);
            return true;
        }
        return false;
    }
    /**
     * Collections 这个类中还提供了一套完备的包装类，分别把 ArrayList、 HashSet 和 HashMap 包装成了线程安全的 List、Set 和 Map。
     */
    private void test() {
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
    }
    /**
     *  错误示例：在容器领域一个容易被忽视的“坑”是用迭代器遍历容器，存在并发问题，这些组合的操作不具备原子性
     */
    private void testV2() {
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        Iterator i = list.iterator();
        while (i.hasNext())
            foo(i.next());
    }

    /**
     * 正确示例：锁住 list 之后再执行遍历操作，包装类的公共方法锁的是对象的 this，这里就是 list
     */
    private void testV3() {
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        synchronized (list){
            Iterator i = list.iterator();
            while (i.hasNext())
                foo(i.next());
        }
    }

    private void foo(Object o){}
}
