package com.kr.caption.designmode.jiketime.jike19Chapter;

public abstract class TestCase {

    public void run() {
        if (doTest()) {
            System.out.println("Test succeed. ");
        } else {
            System.out.println("Test failed. ");
        }
    }

    public abstract Boolean doTest();

}
