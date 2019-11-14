package com.kr.caption.spring.aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * 使用pointcut注解定义重复的使用多次的 切点表达式
 * 这个类虽然使用了注解，但是这个类还是正常的类，和其他类没什么不同，只不过注解会表明这个类会作为切面使用
 */
@Aspect   //定义切面
public class AudienceV2 {

    @Pointcut("execution(**aspect.Perforence.perform(..))")
    private void performence(){}


    @Before("performence()")
    public void silenceCellPhones() {
        System.out.println(" Silence Cell Phones");
    }

    @Before("performence()")
    public void takeSeats() {
        System.out.println(" take Seats");
    }

    @AfterReturning("performence()")
    public void applause() {
        System.out.println("applause");
    }

    /**
     * 在跑出异常之后使用
     */
    @AfterThrowing("performence()")
    public void demandRefund() {
        System.out.println("demand Refund");
    }


    /**
     * 虽然有了注解，这个类也可以注入到Spring容器中
     * @return
     */
    @Bean
    private Audience audience(){
        return new Audience();
    }



}
