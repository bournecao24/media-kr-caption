package com.kr.caption.java8.movingparam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }

    public static void main(String[] args) {

        //排序的转换

        //传递代码
        List<Apple> list = new ArrayList<>();
        list.sort(new AppleComparator());


        //使用匿名类
        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });



        list.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        list.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        list.sort(Comparator.comparing((a) -> a.getWeight()));

        list.sort(Comparator.comparing(Apple::getWeight));

        list.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));


        Predicate<Apple> apple = (Apple a) -> a.getWeight() > 1;
        Predicate<Apple> negate = apple.negate();  //否


    }
}
