package com.kr.caption.designmode.jiketime.jike49Chapter;

import java.util.List;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-22
 * @Description:
 */
public class EmailMsgSender implements MsgSender{

    private List<String> emails;

    public EmailMsgSender(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void send(String message) {

    }
}
