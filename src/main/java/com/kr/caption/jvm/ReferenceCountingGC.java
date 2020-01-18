package com.kr.caption.jvm;


/**
 * -XX:+PrintGCDetails   打印GC日志
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1M= 1024 * 1024;

    private byte [] bigSize = new byte[2* _1M];

    public static void testGC(){

        ReferenceCountingGC countingGCA = new ReferenceCountingGC();
        ReferenceCountingGC countingGCB = new ReferenceCountingGC();

        countingGCA.instance = countingGCB;
        countingGCB.instance = countingGCA;

        countingGCA = null;
        countingGCB = null;


        System.gc();

    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}
