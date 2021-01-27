package com.kr.caption.designmode.jiketime.jike56Chapter.v3;

import com.kr.caption.designmode.jiketime.jike56Chapter.v2.PromotionService;
import com.kr.caption.designmode.jiketime.jike56Chapter.v2.RegObserver;


/**
 *
 * 异步非阻塞观察者模式的简易实现：频繁地创建和销毁线程比较耗时，并且并发线程数无法控制，创建过多的线程会导致堆栈溢出
 *
 */
public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService; // 依赖注入

    @Override
    public void handleRegSuccess(long userId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                promotionService.issueNewUserExperienceCash(userId);
            }
        });
        thread.start();
    }
}
