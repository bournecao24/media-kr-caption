package com.kr.caption.designmode.jiketime.jike56Chapter.v2;

public class RegPromotionObserver implements RegObserver{
    private PromotionService promotionService; // 依赖注入

    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
