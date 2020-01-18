package com.kr.caption.jvm;

public class FinalizeEscapeGC {
    private static FinalizeEscapeGC SAVE_HOOK = null;

    private void isAlive(){
        System.out.println("yes, i am alive");
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();

        System.out.println("finalize method executed ");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象成功拯救自己一次
        SAVE_HOOK = null;
        System.gc();

        //finalize 方法优先级很低，所以等待
        Thread.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("i am dead");
        }

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("i am dead");
        }
    }

}
