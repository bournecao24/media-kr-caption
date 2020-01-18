package com.kr.caption.effective;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackE<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackE() {
        //不能创建一个不可具体化类型的数组，例如类型 E 。每当编写一个由数组支持的泛型时，就会出现此问题。 有两种合理的方法来解决它。 第一种解决方案直接规避了对泛型数组创建的禁用:创建一个
        //Object 数组并将其转换为泛型数组类型
//        elements =new E[DEFAULT_INITIAL_CAPACITY];
        elements =(E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference return result;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
