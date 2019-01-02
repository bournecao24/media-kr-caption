package com.kr.caption.designmode.strategy;


/**
 * 在运行的时候动态的改变行为
 */
public class ModelDuck extends Duck {

    @Override
    public void display() {
        System.out.println(" i am a model duck ");

    }
}
