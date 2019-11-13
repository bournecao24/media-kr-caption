package com.kr.caption.spring.aspect;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 这几个方法都是使用了通知注解来表明它们应该在什么时候调用
 */
@Aspect   //定义切面
public class Audience {


    @Before("execution(**aspect.Perforence.perform(..))")
    public void silenceCellPhones() {
        System.out.println(" Silence Cell Phones");
    }

    @Before("execution(**aspect.Perforence.perform(..))")
    public void takeSeats() {
        System.out.println(" take Seats");
    }

    @AfterReturning("execution(**aspect.Perforence.perform(..))")
    public void applause() {
        System.out.println("applause");
    }

    /**
     * 在跑出异常之后使用
     */
    @AfterThrowing("execution(**aspect.Perforence.perform(..))")
    public void demandRefund() {
        System.out.println("demand Refund");
    }


}
