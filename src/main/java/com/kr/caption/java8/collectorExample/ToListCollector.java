package com.kr.caption.java8.collectorExample;

import com.kr.caption.java8.movingparam.Apple;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {


    //创建集合操作的起始点
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    //累计遍历过的项目，原位修改累加器
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    //修改第一个累加器，将第一个与第二个合并，将第二个返回
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) ->{
            list1.addAll(list2);
            return list1;
        };
    }

    //恒等函数
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    //为收集器添加IDENTITY _FINISH和CONCURRENT标志
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
                IDENTITY_FINISH, CONCURRENT));
    }


    //Stream有一个重载的collect方法可以接受另外三个函数——supplier、 accumulator和combiner
    private void testCollect(List<Apple>list){
        list.stream().collect(ArrayList::new, List::add, List::addAll);
    }
}
