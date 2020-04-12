package com.kr.caption.concurrent.jike1Chapter;


/**
 * 在 Java 领域一个经典的案例就是利用双重检查创建单例对象
 * 假设有两个线程 A、B 同时调用 getInstance() 方法，他们会同时发现 instance == null ，于是同时对 Singleton.class 加锁，此时 JVM 保证只有一个线程能够加锁成功
 * (假设是线程 A)，另外一个线程则会处于等待状态(假设是线程 B);线程 A 会创建一 个 Singleton 实例，之后释放锁，锁释放后，
 * 线程 B 被唤醒，线程 B 再次尝试加锁，此时是可以加锁成功的，加锁成功后，线程 B 检查 instance == null 时会发现，已经创建过 Singleton 实例了，所以线程 B 不会再创建一个 Singleton 实例。
 */
public class Singleton {
    static Singleton instance;
    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
