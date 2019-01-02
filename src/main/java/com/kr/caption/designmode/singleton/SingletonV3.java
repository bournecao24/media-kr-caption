package com.kr.caption.designmode.singleton;


/**
 * 多线程应该这么做，迫使每个线程进入这个方法之前，确定别的线程离开
 * 另外：同步一个方法可能会造成一个程序的效率下降100倍
 */
public class SingletonV3 {

    private static SingletonV3 uniqueInstance;

    private SingletonV3() {
    }

    public static synchronized SingletonV3 getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonV3();
        }
        return uniqueInstance;
    }

}
