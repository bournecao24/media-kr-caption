package com.kr.caption.designmode.jiketime.jike42Chapter;

/**
 * 单例不支持有参数的构造函数 第三种解决办法：将参数放到另外一个全局变量中
 * Config 是一 个存储了 paramA 和 paramB 值的全局变量。里面的值既可以像下面的代码那样通过静态 常量来定义，也可以从配置文件中加载得到。实际上，这种方式是最值得推荐的。
 */
public class SingletonV3 {
    private static SingletonV3 instance = null;
    private final int paramA;
    private final int paramB;

    public SingletonV3() {
        this.paramA = Config.PARAM_A;
        this.paramB = Config.PARAM_B;
    }

    public static SingletonV3 getInstance() {
        if (instance == null) {
            instance = new SingletonV3();
        }
        return instance;
    }
}
