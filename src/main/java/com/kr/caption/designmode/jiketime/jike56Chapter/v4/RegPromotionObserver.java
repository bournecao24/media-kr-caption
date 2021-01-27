package com.kr.caption.designmode.jiketime.jike56Chapter.v4;

import com.google.common.eventbus.Subscribe;
import com.kr.caption.designmode.jiketime.jike56Chapter.v2.PromotionService;

public class RegPromotionObserver{
    private PromotionService promotionService; // 依赖注入

    @Subscribe
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
