package com.kr.caption.concurrent.jike23Chapter.v2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public  class Demo3 {
    //使用默认线程池
    static CompletableFuture<Void> runAsync(Runnable runnable) {
        return null;
    }

    static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        return null;
    }

    //可以指定线程池
    static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor) {
        return null;
    }

    static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor) {
        return null;
    }
}
