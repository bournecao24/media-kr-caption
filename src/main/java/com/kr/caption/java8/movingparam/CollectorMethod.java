package com.kr.caption.java8.movingparam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CollectorMethod<T> {


    /**
     * 建立一个新的结果容器
     * @return
     */
    public Supplier<List<T>> supplier(){
        return () ->new ArrayList<T>();
    }

    public Supplier<List<T>> supplier1(){
        return ArrayList::new;
    }
}
