package com.kr.caption.java8.option;

import com.kr.caption.java8.movingparam.Apple;

import java.util.Optional;
import java.util.Properties;

public class OptionTest {


    private void optionTest() {

        Apple apple = new Apple();


        Optional<Object> option = Optional.empty();

        //如果apple为空， 会抛出空指针
        Optional<Apple> appleOption = Optional.of(apple);

        //可接受空值
        Optional<Apple> appleNull = Optional.ofNullable(apple);

        //提供map方法，从对象中提取信息
        Optional<String> name = appleNull.map(Apple::getName);

        //如果apple为空会抛出异常
        Apple apple1 = appleOption.get();

        //不包含值的时候提供默认值
        Apple apple2 = appleOption.orElse(new Apple());

        //通过方法来提供
        appleOption.orElseGet(Apple::new);

        if (appleOption.isPresent()) {

        }

        //filter
        appleOption.filter(apples -> apples.getWeight() > 300).ifPresent(X -> System.out.println("ok"));


    }


    private Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }


    public int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {
            }
        }
        return 0;
    }


    public int readDurationV2(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(this::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }


    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        OptionTest optionTest = new OptionTest();
        optionTest.readDurationV2(props, "a");

    }


}
