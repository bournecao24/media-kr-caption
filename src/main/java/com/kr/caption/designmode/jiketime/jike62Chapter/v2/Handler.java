package com.kr.caption.designmode.jiketime.jike62Chapter.v2;

public abstract class Handler {
    protected Handler successor = null;
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    public final void handle() {
        boolean handled = doHandle();
        if (successor != null && !handled) {
            successor.handle();
        }
    }
    public abstract boolean doHandle();
}
