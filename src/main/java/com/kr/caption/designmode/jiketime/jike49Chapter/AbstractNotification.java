package com.kr.caption.designmode.jiketime.jike49Chapter;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-22
 * @Description:
 */
public abstract class AbstractNotification {

    protected MsgSender msgSender;


    public AbstractNotification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}
