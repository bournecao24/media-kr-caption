package com.kr.caption.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xss128K
 */
public class JavaStackSOf {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaStackSOf javaStackSOf = new JavaStackSOf();
        try {
            javaStackSOf.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length : " + javaStackSOf.stackLength);
            throw  e;
        }
    }
}
