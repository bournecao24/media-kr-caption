package com.kr.caption.java8.movingparam;

@FunctionalInterface
public interface AboutCheckExecption<T, U, V, R> {
    R apply(T t, U u, V v);
}
