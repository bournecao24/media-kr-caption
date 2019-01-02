package com.kr.caption.designmode.observer;


/**
 * 报纸订阅服务
 * 定义了对象之间的一对多依赖，当一个对象改变状态的时候，所有依赖者都会收到通知。
 * 对象设计，让主题和观察者之间松耦合
 * 当两个对象之间松耦合，他们依然可以交互，但是不太清楚彼此之间的细节
 * 互相依赖降到了最低
 */
public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObserver();
}
