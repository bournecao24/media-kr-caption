package com.kr.caption.designmode.strategy;

public class FlyRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println(" i am flying by rocket");
    }
}
