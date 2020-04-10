package com.kr.caption.designmode.jiketime.jike56Chapter.v4;

import com.kr.caption.designmode.jiketime.jike56Chapter.v2.NotificationService;

public class RegNotificationObserver {
    private NotificationService notificationService;

    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, " ");
    }
}
