package com.kr.caption.java8.movingparam;

import org.apache.ibatis.annotations.Param;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class lambda {

    public static void main(String[] args) {

        //   参数列表，参数   ->   返回值（lambda主体）

        //五种lambda
        Consumer<String> stringConsumer = (String s) -> s.length();

        Predicate<Apple> predicate = ((Apple a) -> a.getWeight() > 150);

//        (int x, int y) -> {
//            System.out.println("Result");
//            System.out.println(x + y);
//        };

//        () -> 42;

//        (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        //函数式接口的实现
        Runnable runnable = () -> System.out.println("Hello world1");

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello word");
            }
        };

    }
}
