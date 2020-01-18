package com.kr.caption.effective;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Effective Java
 * 合理地结合泛型和可变参数
 */
public interface Test {

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = new ArrayList<>(42);
        Object[] objects = stringLists;
        objects[0] = intList; // Heap pollution
        String s = stringLists[0].get(0); // ClassCastException
    }


    /**
     * 这个方法只是返回它的可变参数数组，由于此方法返回其可变参数数组，它可以将 堆污染传播到调用栈上。
     *
     * @param args
     * @param <T>
     * @return
     */
    static <T> T[] toArray(T... args) {
        return args;
    }


    /**
     * 编译此方法时，编译器会生成代码以创建一个将两个 T 实例传递给 toArray 的可变参数数组。 这段代码分配了 一个 Object[] 类型的数组，它是保证保存这些实例的最具体的类型，而不管在调用位置传递给 pickTwo 的对象是 什么类型。 toArray 方法只是简单地将这个数组返回给 pickTwo ，然后 pickTwo 将它返回给调用者，所以
     * pickTwo 总是返回一个 Object[] 类型的数组。
     *
     * @param a
     * @param b
     * @param c
     * @param <T>
     * @return
     */
    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }


    /**
     * Safe method with a generic varargs parameter
     *
     * @param lists
     * @param <T>
     * @return
     */
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }
}
