package com.kr.caption.java8.movingparam;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamCollectData {


    //源码
    public static <T> Collector<T, ?, Long> counting() {
        return reducing(0L, e -> 1L, Long::sum);
    }


    public static void DataCollect() {
        List<Apple> list = new ArrayList<>();

        long totalCalories = list.stream().mapToLong(Apple::getWeight).sum();

        //分组
        Map<String, List<Apple>> listMap = list.stream().collect(groupingBy(Apple::getName));

        //自定义的去分组
        list.stream().collect(groupingBy(apple -> {
            if (apple.getWeight() > 300) {
                return "Heavy";
            } else if (apple.getWeight() < 200) {
                return "little";
            } else {
                return "normal";
            }
        }));


        //和groupby一起的mapping
        list.stream().collect(groupingBy(Apple::getType, mapping(apple -> {
                    if (apple.getWeight() > 300) {
                        return "Heavy";
                    } else if (apple.getWeight() < 200) {
                        return "little";
                    } else {
                        return "normal";
                    }
                }, toSet()
        )));

        list.stream().collect(groupingBy(Apple::getType, mapping(apple -> {
                    if (apple.getWeight() > 300) {
                        return "Heavy";
                    } else if (apple.getWeight() < 200) {
                        return "little";
                    } else {
                        return "normal";
                    }
                }, toCollection(HashSet::new)
        )));


        //多级分组
        Map<Integer, Map<String, List<Apple>>> appleMap = list.stream().collect(
                groupingBy(Apple::getType,
                        groupingBy(dish -> {
                            if (dish.getWeight() <= 400) return "DIET";
                            else if (dish.getWeight() <= 700) return "NORMAL";
                            else return "FAT";
                        })));

        //按子组收集数据,可以对每个组里面的对象进行归约操作
        Map<Integer, Long> typeNum = list.stream().collect(
                groupingBy(Apple::getType, counting()));

        Map<Integer, Long> longMap = list.stream().collect(
                groupingBy(Apple::getType, summingLong(Apple::getWeight)));

        Map<Integer, Optional<Apple>> optionalMap = list.stream().collect(groupingBy(Apple::getType, maxBy(Comparator.comparingLong(Apple::getWeight))));

        Map<Integer, Apple> integerAppleMap = list.stream().collect(groupingBy(Apple::getType, collectingAndThen(maxBy(Comparator.comparingLong(Apple::getWeight)), Optional::get)));


        //分区函数 ,只分为两组
        Map<Boolean, List<Apple>> collect = list.stream().collect(partitioningBy(Apple::isHasGrow));

        Map<Boolean, Map<Integer, List<Apple>>> collect1 = list.stream().collect(partitioningBy(Apple::isHasGrow, groupingBy(Apple::getType)));

        //熟的和没熟的中最重的
        Map<Boolean, Apple> mostCaloricPartitionedByVegetarian =
                list.stream().collect(
                        partitioningBy(Apple::isHasGrow,
                                collectingAndThen(maxBy(Comparator.comparingLong(Apple::getWeight)),
                                        Optional::get)));


    }


    private void aboutFlatMap() {

        String[] words = {"Hello Guys", "Welcome Follow me"};

        Arrays.stream(words).map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());

        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {3, 4};

        Arrays.stream(arr1).flatMap(a -> Arrays.stream(arr2).map(b -> new Integer[]{a, b})).collect(Collectors.toList());

        long count = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).count();

        Stream<String> stream = Stream.of("Welcome  ", "Follow ", "me ");

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();



    }


}
