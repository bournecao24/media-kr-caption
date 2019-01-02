package com.kr.caption.designmode.adapter;

public class MallardDuck implements Duck{
    @Override
    public void quack() {
        System.out.println(" Quack");
    }

    @Override
    public void fly() {
        System.out.println("i am flying");
    }
}
