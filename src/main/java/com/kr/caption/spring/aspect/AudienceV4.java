package com.kr.caption.spring.aspect;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 */
public class AudienceV4 {


    public void silenceCellPhones() {
        System.out.println(" Silence Cell Phones");
    }

    public void takeSeats() {
        System.out.println(" take Seats");
    }

    public void applause() {
        System.out.println("applause");
    }

    public void demandRefund() {
        System.out.println("demand Refund");
    }


}
