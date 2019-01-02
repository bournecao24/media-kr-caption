package com.kr.caption.designmode.singleton;

public class SingletonV2 {

    private static SingletonV2 uniqueInstance;  //静态的，唯一的

    private SingletonV2(){}

    public static SingletonV2 getInstance(){   //这个方法为什么是 static 的？是一个类方法，可以在任何地方使用
        if(uniqueInstance == null){
            uniqueInstance = new SingletonV2();
        }
        return uniqueInstance;
    }

}
