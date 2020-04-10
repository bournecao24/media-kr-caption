package com.kr.caption.designmode.jiketime.jike56Chapter;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Message message);
}
