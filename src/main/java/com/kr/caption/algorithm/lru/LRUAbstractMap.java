package com.kr.caption.algorithm.lru;

import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;

public class LRUAbstractMap extends java.util.AbstractMap {

    // 检查是否超期
    private ExecutorService checkTimePool ;

    // map 最大size
    private final static int MAX_SIZE = 1024 ;


    private final static ArrayBlockingQueue<Node> QUEUE = new ArrayBlockingQueue<>(MAX_SIZE) ;






















    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
