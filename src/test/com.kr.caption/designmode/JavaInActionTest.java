package com.kr.caption.designmode;

import com.kr.caption.java8.movingparam.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaInActionTest {

    public static void main(String[] args) {

        Apple apple = new Apple();
        apple.setName("j a c k");

        Apple apple1 = new Apple();
        apple1.setName("j e r r y");
        List<Apple> appleList = new ArrayList<>();
        appleList.add(apple);
        appleList.add(apple1);

        System.out.println((Arrays.toString("j a k".split(" "))));
        List<String> collect = appleList.stream().map(Apple::getName).map(word -> word.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(collect);

    }


    private void twoArrays() {

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
    }

}
