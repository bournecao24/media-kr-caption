package com.kr.caption.designmode.strategy;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {

        System.out.println("Quack");
    }
}
