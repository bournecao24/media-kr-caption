package com.kr.caption.concurrent.jike4Chapter;


/**
 * 账户类 Account 有两个成员变量，账户余额 balance 和账户密码 password。
 * 取款 withdraw() 和查看余额 getBalance() 操作会访问账户余额 balance，我们创建一个 final 对象 balLock 作为锁(类比球场门票);
 * 更改密码 updatePassword() 和查看密码 getPassword() 操作会修改账户密码 password，我们创建一个 final 对象 pwLock 作为锁(类比电影票)。
 * 不同的资源用不同的锁保护，各自管各自的，很简单。
 *
 * 也可以用一把互斥锁来保护多个资源，例如我们可以用 this 这一把锁来管理账户类里所有的资源: 账户余额和用户密码。
 * 具体实现很简单，示例程序中所有的方法都增加同步关键字 synchronized 就可以了
 */
public class Account {
    // 锁:保护账户余额
    private final Object balLock = new Object();

    // 账户余额
    private Integer balance;

    // 锁:保护账户密码
    private final Object pwLock = new Object();

    // 账户密码
    private String password;

    //取款
    void withdraw(Integer amt) {
        synchronized (balLock) {
            if (this.balance > amt) {
                this.balance -= amt;
            }
        }
    }

    // 查看余额
    Integer getBalance() {
        synchronized (balLock) {
            return balance;
        }
    }

    // 更改密码
    void updatePassword(String pw) {
        synchronized (pwLock) {
            this.password = pw;
        }
    }

    // 查看密码
    String getPassword() {
        synchronized (pwLock) {
            return password;
        }
    }
}
