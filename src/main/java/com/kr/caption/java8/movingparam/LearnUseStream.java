package com.kr.caption.java8.movingparam;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class LearnUseStream {


    public static void main(String[] args) {


        List<Apple> appleList = new ArrayList<>();

        List<Apple> red = appleList.stream()
                .filter(apple -> apple.getColor().equals("red"))
                .peek(System.out::println)
                .distinct()
                .limit(3).collect(Collectors.toList());


        List<String> appleNameList = appleList.stream().map(Apple::getColor).collect(Collectors.toList());

        Optional<String> anyObject = appleList.stream().map(Apple::getColor).findAny();

        boolean isAllHeavy = appleList.stream().allMatch(apple -> apple.getWeight() > 100);

        //归约
        List<Integer> numbers = new ArrayList<>();
        Integer allSum = numbers.stream().reduce(0, (a, b) -> a + b);

        Integer allInteger = numbers.stream().reduce(0, Integer::sum);

        Optional<Integer> result = numbers.stream().reduce(Integer::sum);
        Optional<Integer> maxResult = numbers.stream().reduce(Integer::max);
        Optional<Integer> minResult = numbers.stream().reduce(Integer::min);

        //无初始值
        Optional<Integer> reduce = numbers.stream().reduce(Integer::sum);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);

        Optional<String> any = appleList.stream().map(Apple::getName).map(word -> word.split("")).flatMap(Arrays::stream).distinct().findAny();

        //勾股数
        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(1, 100)
                        .mapToObj(b -> new double[]{a * a + b * b})
                        .filter(t -> t[2] % 1 == 0));

        //文件流
        long uniquesWords = 0l;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniquesWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //无限流
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(5).forEach(System.out::println);


        //把苹果按颜色分组
        List<Apple> appleAllList = new ArrayList<>();
        Map<String, List<Apple>> appleByColorMap = new HashMap<>();
        for (Apple apple : appleAllList) {
            String color = apple.getColor();
            if (appleByColorMap.get(color) == null) {
                List<Apple> appList = new ArrayList<>();
                appList.add(apple);
                appleByColorMap.put(color, appList);
            } else {
                List<Apple> apples = appleByColorMap.get(color);
                apples.add(apple);
            }
        }


        appleByColorMap = appleAllList.stream().collect(groupingBy(Apple::getColor));

        //重量最终 查最大值
        Comparator<Apple> tComparator = Comparator.comparingLong(Apple::getWeight);
        Optional<Apple> collect = appleAllList.stream().max(tComparator);

        // 求和 汇总
        Long allWeight = appleAllList.stream().collect(summingLong(Apple::getWeight));
        //平均数
        Double collectAvg = appleAllList.stream().collect(averagingLong(Apple::getWeight));


        //都放到一起了
        LongSummaryStatistics summaryStatistics = appleAllList.stream().collect(summarizingLong(Apple::getWeight));

        //链接字符串
        String nameStr = appleAllList.stream().map(Apple::getName).collect(joining());

        appleAllList.stream().map(Apple::getWeight).reduce((i, j) -> i + j);


        appleAllList.stream().collect(reducing((a1, a2) -> a1.getWeight() > a2.getWeight() ? a1 : a2));

        appleAllList.stream().reduce((a1, a2) -> a1.getWeight() > a2.getWeight() ? a1 : a2);

//        appleAllList.stream().collect(reducing(0, Apple::getWeight, (i, j) -> i + j));

        Optional<Apple> mostCalorieDish = appleAllList.stream().collect(reducing((d1, d2) -> d1.getWeight() > d2.getWeight() ? d1 : d2));

        //收集和归约
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbersColl = stream.reduce(new ArrayList<Integer>(), (List<Integer> l, Integer e) -> {
            l.add(e);
            return l;
        }, (List<Integer> l1, List<Integer> l2) -> {
            l1.addAll(l2);
            return l1;
        });

    }

}
