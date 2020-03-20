package com.kr.caption.designmode.jiketime.jike16Chapter.refactoring;

import com.kr.caption.designmode.jiketime.jike16Chapter.AlertRule;
import com.kr.caption.designmode.jiketime.jike16Chapter.Notification;

public class ApplicationContext {

    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans() {
        alertRule = new AlertRule(/*. 省略参数.*/); // 省略一些初始化代码
        notification = new Notification(/*. 省略参数.*/); // 省略一些初始化代码
        alert = new Alert();
        alert.addHandler(new TpsAlertHandler(alertRule, notification));
        alert.addHandler(new ErrorAlertHandler(alertRule, notification));
    }

    public Alert getAlert() {
        return alert;
    }



    // 饿汉式单例模式
    private static final ApplicationContext instance = new ApplicationContext();
    public ApplicationContext() {
        instance.initializeBeans();
    }

    public static ApplicationContext getInstance(){
        return instance;
    }
}
