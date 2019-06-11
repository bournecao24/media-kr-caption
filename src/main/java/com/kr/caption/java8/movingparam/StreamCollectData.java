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

        //可以传递第二个收集器
        Map<Boolean, Map<Integer, List<Apple>>> collect1 = list.stream().collect(partitioningBy(Apple::isHasGrow, groupingBy(Apple::getType)));

        //熟的和没熟的中最重的
        Map<Boolean, Apple> mostCaloricPartitionedByVegetarian =
                list.stream().collect(
                        partitioningBy(Apple::isHasGrow,
                                collectingAndThen(maxBy(Comparator.comparingLong(Apple::getWeight)),
                                        Optional::get)));

        //多级分区
        Map<Boolean, Map<Boolean, List<Apple>>> mapMap = list.stream().collect(partitioningBy(Apple::isHasGrow, partitioningBy(Apple::isHasSweet)));

        Map<Boolean, Long> mapNum = list.stream().collect(partitioningBy(Apple::isHasGrow, counting()));

        //把结果收集到指定集合
        list.stream().collect(Collectors.toCollection(ArrayList::new));


    }

//    public class ToListCollector<T> implements Collector<T, List<T>, List<T>>{
//
//    }

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


    /**
     * 是否是质数
     * @param candidate
     * @return
     */
    private boolean isPrime(int candidate) {
        return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
    }

    /**
     * 是否是质数优化：仅测试小于等于待测数平方根的因子
     * Collectors类的静态工厂方法创建所有的收集器
     *
     * 质数：除了1和它本身，不能被任何自然数整除的数
     * 先取被测试数的平方根，用 被测试数去整除从2到平方根的这些数。
     * @param candidate
     * @return
     */
    private static boolean isPrimeBetter(int candidate){
        int sqrt = (int)Math.sqrt(candidate);
        System.out.println(sqrt);
        return IntStream.rangeClosed(2, sqrt).noneMatch(num -> candidate % num ==0);
    }

    public static void main(String[] args) {
        int candidate = 36;
        System.out.println(isPrimeBetter(candidate));
    }


}
