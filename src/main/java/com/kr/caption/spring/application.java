package com.kr.caption.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application_example.xml");
        Train bean = context.getBean(Train.class);
        bean.catchGoods();

    }
}
