package com.kr.caption.designmode.jiketime.jike49Chapter;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-22
 * @Description:
 */
public class UrgencyNotification extends AbstractNotification{

    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
