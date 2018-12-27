package com.kr.caption.designmode.singleton;

public class Singleton {

    private static Singleton uniqueInstance = new Singleton();

    private Singleton() {
    }

    public Singleton getInstance(){
        return uniqueInstance;
    }
}
