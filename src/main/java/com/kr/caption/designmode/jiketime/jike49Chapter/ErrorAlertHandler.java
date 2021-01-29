package com.kr.caption.designmode.jiketime.jike49Chapter;


import com.kr.caption.designmode.jiketime.jike16Chapter.AlertRule;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-22
 * @Description:
 */
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    /**
     *  问题 ： if-else 分支会有很多
     *
     *  类的代码越多，就越难读懂，越难修改，维护的成本也就越高
     * @param apiStatInfo
     */
    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if(apiStatInfo.getErrorCount() > rule.getMatchRule(apiStatInfo.getApi())){
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }

    }
}
