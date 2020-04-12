package com.kr.caption.designmode.jiketime.jike62Chapter;

/**
 *  处理器类的 handle() 函数，不仅包含自己的业务逻 辑，还包含对下一个处理器的调用，也就是代码中的 successor.handle()
 */
public class HandlerA extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        //...
        System.out.println(" HandlerA amazing ");
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
