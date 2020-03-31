package com.kr.caption.designmode.jiketime.jike42Chapter;

/**
 * 单例不支持有参数的构造函数 第二种解决办法：将参数放到 getInstance() 方法中
 * 问题：如果我们如下两次执行 getInstance() 方法，那获取到的 singleton1 和 singleton2 的 paramA 和 paramB 都是 10 和 50。
 * 也就是说，第二次的参数(20，30)没有起作用，而构建的过程也没有给与提示，这样就会误导用户
 */
public class SingletonV2 {
    private static SingletonV2 instance = null;
    private final int paramA;
    private final int paramB;

    public SingletonV2(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static SingletonV2 getInstance(int paramA, int paramB) {
        if (instance == null) {
            instance = new SingletonV2(paramA, paramB);
        }
        return instance;
    }
}
