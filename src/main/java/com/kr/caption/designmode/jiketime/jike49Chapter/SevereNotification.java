package com.kr.caption.designmode.jiketime.jike49Chapter;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-22
 * @Description:
 */
public class SevereNotification extends AbstractNotification{

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
