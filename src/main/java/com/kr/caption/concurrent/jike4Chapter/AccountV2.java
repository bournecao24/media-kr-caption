package com.kr.caption.concurrent.jike4Chapter;

/**
 * 问题就出在 this 这把锁上，this 这把锁可以保护自己的余额 this.balance，却保护不了别人的余额 target.balance，就像你不能用自家的锁来保护别人家的资产，也不能用自己的票来保护别人的座位一样。
 */
public class AccountV2 {

    private int balance;

    synchronized void transfer(AccountV2 target, int amt) {
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }
}
