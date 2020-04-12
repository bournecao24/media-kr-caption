package com.kr.caption.designmode.jiketime.jike62Chapter;

public class HandlerB extends Handler {

    @Override
    public void handle() {
        boolean handled = false;
        //...
        System.out.println(" HandlerB amazing ");

        if (!handled && successor != null) {
            successor.handle();
        }

    }
}
