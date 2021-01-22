package com.kr.caption.designmode.jiketime.jike49Chapter;

import java.util.List;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-22
 * @Description:
 */
public class Notification {

    private List<String> emailAddresses;
    private List<String> telephones;
    private List<String> wechatIds;


    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public void setWechatIds(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }


    public void notify(NotificationEmergencyLevel level, String message) {

        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            //...自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //...发微信
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //...发邮件
        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            //...发邮件
        }


    }

}
