package com.kr.caption.designmode.jiketime.jike56Chapter.v3;

import com.kr.caption.designmode.jiketime.jike56Chapter.v2.PromotionService;
import com.kr.caption.designmode.jiketime.jike56Chapter.v2.RegObserver;


/**
 * 异步非阻塞观察者模式的简易实现
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
