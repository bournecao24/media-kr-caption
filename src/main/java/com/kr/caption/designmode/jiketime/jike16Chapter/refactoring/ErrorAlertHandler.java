package com.kr.caption.designmode.jiketime.jike16Chapter.refactoring;

import com.kr.caption.designmode.jiketime.jike16Chapter.AlertRule;
import com.kr.caption.designmode.jiketime.jike49Chapter.Notification;

public class ErrorAlertHandler extends AlertHandler {


    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchRule(apiStatInfo.getApi())) {
            notification.notify();
        }
    }
}
