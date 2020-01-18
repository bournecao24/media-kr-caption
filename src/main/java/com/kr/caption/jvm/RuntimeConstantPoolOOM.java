package com.kr.caption.jvm;

import java.util.ArrayList;
import java.util.List;


/**
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用List保持常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
