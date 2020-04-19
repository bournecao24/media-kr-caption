package com.kr.caption.concurrent.jike4Chapter;

/**
 * 在编程世界，用两把锁就实现了，转出账本一把，转入账本另一把。在 transfer() 方法内部，我们首先尝试锁定转出账户 this(先把转出账本拿到手)，然后尝试锁定转入账户 target(再把转入账本拿到手)，
 * 只有当两者都成功时，才执行转账操作。
 */
public class AccountV5 {
    private Integer balance;

    // 转账
    void transfer(AccountV5 target, int amt) {
        // 锁定转出账户
        synchronized (this) {
            // 锁定转入账户
            synchronized (AccountV5.class) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}