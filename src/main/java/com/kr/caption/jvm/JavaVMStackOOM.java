package com.kr.caption.jvm;

public class JavaVMStackOOM {

    private void dontStop(){
    }

    private void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaStackSOf = new JavaVMStackOOM();
        javaStackSOf.stackLeakByThread();
    }
}
