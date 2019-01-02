package com.kr.caption.designmode.strategy;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println(" i am a real Mallard duck ");
    }
}
