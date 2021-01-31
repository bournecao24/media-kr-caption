package com.kr.caption.designmode.jiketime.jike65Chapter.v2;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-31
 * @Description:
 */
public class Demo {


    public static void main(String[] args) {
        java.util.ArrayList<String> names = new java.util.ArrayList<>();

        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        java.util.Iterator<String> iterator = names.iterator();
        iterator.next();
        iterator.remove();
        iterator.remove(); //报错，抛出IllegalStateException异常

    }

}
