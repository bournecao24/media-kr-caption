package com.kr.caption.designmode.jiketime.jike62Chapter;

public class HandlerC extends Handler {

    @Override
    public void handle() {
        boolean handled = false;
        System.out.println(" HandlerC amazing ");

        if (!handled && successor != null) {
            successor.handle();
        }

    }
}
