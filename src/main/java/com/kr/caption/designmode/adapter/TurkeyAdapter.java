package com.kr.caption.designmode.adapter;

/**
 * 实现想转换成的类型接口
 * 将一个类的接口转换为期望的那个接口
 * 适配器可以将改变的部分封装起来
 */
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
