package com.kr.caption.designmode.template.designresult;

public class Tea extends CaffeineBeverage {

    @Override
    public void brew() {
        System.out.println(" Steeping the tea ");
    }

    @Override
    public void addCondiments() {
        System.out.println(" adding lemon ");
    }
}
