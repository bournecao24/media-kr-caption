package com.kr.caption.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUMethodA<K, V> extends LinkedHashMap<K,V> {

    private final int CACHE_SIZE;


    public LRUMethodA(int cacheSize) {
        // true 让 LinkHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部
        super((int)Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        this.CACHE_SIZE = cacheSize;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        // 当 map 的中的数据大于最大的，自动删除最老的那个
        return size() > CACHE_SIZE;
    }

}
