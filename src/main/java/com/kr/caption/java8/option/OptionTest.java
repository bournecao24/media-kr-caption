package com.kr.caption.java8.option;

import com.kr.caption.java8.movingparam.Apple;

import java.util.Optional;

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



    }


}
