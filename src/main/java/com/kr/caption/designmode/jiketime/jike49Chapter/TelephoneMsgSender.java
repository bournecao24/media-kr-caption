package com.kr.caption.designmode.jiketime.jike49Chapter;

import java.util.List;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-22
 * @Description:
 */
public class TelephoneMsgSender implements MsgSender{

    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {

    }
}
