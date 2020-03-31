package com.kr.caption.designmode.jiketime.jike42Chapter;

/**
 * 单例不支持有参数的构造函数 第一种解决办法：创建完实例之后，再调用 init() 函数传递参数
 */
public class Singleton {
    private static Singleton instance = null;

    private final int paramA;
    private final int paramB;

    public Singleton(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            throw new RuntimeException("Run init() first.");
        }
        return instance;
    }

    public synchronized static Singleton init(int paramA, int paramB) {
        if (instance != null) {
            throw new RuntimeException("Singleton has been created!");
        }
        instance = new Singleton(paramA, paramB);
        return instance;
    }
}
