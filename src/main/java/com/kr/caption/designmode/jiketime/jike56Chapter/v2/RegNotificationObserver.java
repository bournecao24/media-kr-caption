package com.kr.caption.designmode.jiketime.jike56Chapter.v2;

public class RegNotificationObserver implements RegObserver {

    private NotificationService notificationService;
    @Override
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, " ");
    }
}
