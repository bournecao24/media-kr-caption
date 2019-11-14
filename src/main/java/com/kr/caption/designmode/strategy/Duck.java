package com.kr.caption.designmode.strategy;


/**
 * 策略模式：定义了算法族，分别封装起来，让他们之间可以相互替换，此模式使算法的变化独立于使用算法的客户
 */
public abstract class Duck {

    //两个实例变量，声明为具体的接口类型，这样每个实现类，
    // 也就是鸭子都会动态的设置这些变量用来在运行的时候引用正确的飞行模式
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    public Duck() {
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public abstract void display();

    public void swim(){
        System.out.println(" every duck is swimming ");
    }

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }
}
