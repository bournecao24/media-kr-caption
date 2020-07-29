package com.kr.caption.spring.applicationtest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 这个地方使用了 Spring 的注解 @Component，如果不是使用 annotation 的方式，而是使用 xml 的方式管理 Bean，记得写入配置文件
 *
 * 实现该接口的类会接收到 spring 容器传过来的 ApplicationContext 对象
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 通过传递 applicationContext 参数初始化成员变量 applicationContext
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;

    }


    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }
}
