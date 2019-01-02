package com.kr.caption.designmode.template.designresult;

public class Coffee extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println(" Drop coffee through filter ");

    }

    @Override
    public void addCondiments() {
        System.out.println(" Adding sugar and milk ");

    }
}
