package com.kr.caption.concurrent.jike4Chapter;

/**
 * 方案 ：可以让所有对象都持有一个唯一性的对 象，这个对象在创建 Account 时传入
 * 缺点：要求在创建 Account 对象的时候必须传入同一个对象，在一个项目中，要完成这个要求还是有点难的。
 */
public class AccountV3 {
    private Object lock;
    private Integer balance;

    public AccountV3() {
    }

    public AccountV3(Object lock) {
        this.lock = lock;
    }

    // 转账
    void transfer(AccountV3 target, int amt) {
        // 此处检查所有对象共享的锁
        synchronized (lock) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}