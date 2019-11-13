package com.kr.caption.spring.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;

/**
 * 环绕通知
 */
@Aspect   //定义切面
public class AudienceV3 {

    @Pointcut("execution(**aspect.Perforence.perform(..))")
    private void performance() {
    }


    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {


        try {
            System.out.println(" Silence Cell Phones");
            System.out.println(" take Seats");
            joinPoint.proceed();
            System.out.println("applause");
        } catch (Throwable throwable) {
            System.out.println("demand Refund");
        }


    }


}
