package com.kr.caption.efficient;


/**
 * 尖括号里的每一元素都指代一种未知类型
 * @param <T>
 */
public class GenericDefinitionDemo<T> {

    static <String, T, Apple> String get(String str, Apple apple) {
        return str;
    }

    public static void main(String[] args) {
        Integer first = 234;
        Long second = 456L;

        Integer result = get(first, second);

    }
}
