package com.kr.caption.designmode.jiketime.jike16Chapter;


/**
 * 当接口的 TPS 超过某个预先设置的最大值时，以及当接口请求出错数大于某个最大允许值时，就会触发告警，通知接口的相关负责人或者团队。
 * 需求变化：需要添加一个功能，当每秒钟接口超时请求个数，超过某个预先设置的最大阈值时，我们也要触发告警发送通知。
 */
public class Alert {
    private AlertRule rule;
    private Notification notification;
    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    // 改动一:添加参数 timeoutCount
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds, long timeoutCount){
        long tps = requestCount / durationOfSeconds;

        if(tps > rule.getMatchRule(api)){
            notification.notify();
        }

        if (errorCount > rule.getMatchRule(api)) {
            notification.notify();
        }
        // 改动二:添加接口超时处理逻辑，又一个 if
    }
}
