package com.kr.caption.spring.applicationtest;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 获取 Spring 上下文的三种方式
 */
public class TestApplication {


    /**
     * 依赖 servlet 容器
     */
    private void getApplicationMethod1() {

//        WebApplicationContextUtils.getWebApplicationContext()
    }

    /**
     * 这种方法会重新生成一个 ApplicationContext 对象
     */
    private void getApplicationMethod2() {


        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

    }


}
