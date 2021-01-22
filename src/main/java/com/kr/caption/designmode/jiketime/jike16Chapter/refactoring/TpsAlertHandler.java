package com.kr.caption.designmode.jiketime.jike16Chapter.refactoring;

import com.kr.caption.designmode.jiketime.jike16Chapter.AlertRule;
import com.kr.caption.designmode.jiketime.jike49Chapter.Notification;

public class TpsAlertHandler extends AlertHandler {

    // ? 抽象父类中有构造方法，子类要强制有构造方法且构造方法中调用父类的
    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount()/ apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchRule(apiStatInfo.getApi())) {
            notification.notify();
        }
    }
}
