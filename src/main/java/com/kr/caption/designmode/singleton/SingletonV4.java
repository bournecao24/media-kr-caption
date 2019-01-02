package com.kr.caption.designmode.singleton;

/**
 * 双重检查加锁，在getInstance方法中减少使用同步的频率
 */
public class SingletonV4 {

    private volatile static SingletonV4 uniqueInstance; //volatile :当此变量被初始化成实例的时候，多个线程能正确的处理

    public static SingletonV4 getInstance(){
        if(uniqueInstance == null){
            synchronized (SingletonV4.class){
                if(uniqueInstance == null){
                    uniqueInstance = new SingletonV4();
                }
            }
        }
        return uniqueInstance;
    }
}
