package com.kr.caption.designmode.strategy;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println(" i can not fly");
    }
}
