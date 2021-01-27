package com.kr.caption.designmode.jiketime.jike59Chapter;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-27
 * @Description:
 */
public class AClass {

    public static void main(String[] args) {

        BClass bClass = new BClass();
        bClass.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("Call back me.");
            }
        });
    }
}
