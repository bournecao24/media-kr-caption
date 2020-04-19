package com.kr.caption.concurrent.jike4Chapter;

/**
 * 用 Account.class 作为共享的锁，Account.class 是所有 Account 对象共享的，而且这个对象是 Java 虚拟机在加载 Account 类的时候创建的，所以我们不用担心它的唯一性。
 */
public class AccountV4 {
    private Integer balance;

    // 转账
    void transfer(AccountV4 target, int amt) {
        // 此处检查所有对象共享的锁
        synchronized (AccountV4.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}