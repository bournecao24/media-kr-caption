package com.kr.caption.designmode.jiketime.jike16Chapter.refactoring;

import com.kr.caption.designmode.jiketime.jike16Chapter.AlertRule;
import com.kr.caption.designmode.jiketime.jike49Chapter.Notification;

public abstract class AlertHandler {

    protected AlertRule rule;
    protected Notification notification;
    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);


}
