package com.kr.caption.concurrent.jike5Chapter;

public class AccountV2 {
    private int id;
    private int balance;

    //转账
    void transfer(AccountV2 target, int amt) {
        AccountV2 left = this;
        AccountV2 right = target;
        if (this.id > target.id) {
            left = target;
            right = this;
        }
        // 锁定序号小的账户
        synchronized (left) {
            // 锁定序号大的账户
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
