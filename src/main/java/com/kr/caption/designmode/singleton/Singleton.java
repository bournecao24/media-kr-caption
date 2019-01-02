package com.kr.caption.designmode.singleton;


/**
 * 线程池、缓存，管理共享的资源 举例：如果将一个对象赋值给全局变量，那么就得在程序一开始的时候就得创建好对象，
 * 如果这个对象是非常消耗资源的，而项目中又从没用到，就是很浪费资源的。
 *
 * 这个也是线程安全的，就是在任何线程访问之前，一定是先创建此实例的。
 *
 * 单例模式：一个私有的构造器，一个静态常量，一个静态方法
 */
public class Singleton {

    private static Singleton uniqueInstance = new Singleton();

    private Singleton() {
    }

    public Singleton getInstance(){
        return uniqueInstance;
    }
}
