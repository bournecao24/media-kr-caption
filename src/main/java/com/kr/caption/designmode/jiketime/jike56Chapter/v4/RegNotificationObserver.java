package com.kr.caption.designmode.jiketime.jike56Chapter.v4;

import com.google.common.eventbus.Subscribe;
import com.kr.caption.designmode.jiketime.jike56Chapter.v2.NotificationService;

public class RegNotificationObserver {
    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, " ");
    }
}
