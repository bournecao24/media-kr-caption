package com.kr.caption.designmode.jiketime.jike19Chapter.di;

public class Notification {
    // MessageSender 定义成接口，基于接口而非实现编程
    private MessageSender messageSender;

    // 非依赖注入的方式
    public Notification() {
        this.messageSender = new MessageSender();
    }

    // 依赖注入的方式  提高了代码的可扩展性，可以灵活的替换掉可依赖的类
    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    private void sendMessage(String phone, String message){
        messageSender.send(phone, message);
    }
}
