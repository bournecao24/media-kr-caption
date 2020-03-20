package com.kr.caption.designmode.jiketime.jike19Chapter;

public class Notification {


    // MessageSender 定义成接口，基于接口而非实现编程
    private MessageSender messageSender;

    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }


    private void sendMessage(String phone, String message){
        messageSender.send(phone, message);
    }


}
