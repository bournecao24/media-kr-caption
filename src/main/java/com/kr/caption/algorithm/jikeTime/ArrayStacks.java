package com.kr.caption.algorithm.jikeTime;


/**
 * from 极客时间 8
 * 栈
 * 由数组来实现的是顺序栈，由链表来实现的是动态
 */
public class ArrayStacks {

    private String[] items;
    private int count;
    private int n;

    public ArrayStacks(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }


    private Boolean push(String n) {
        //空间不够
        if (count == 0) {
            return false;
        }

        items[count] = n;
        count++;
        return true;
    }

    private String pop() {
        if (count == 0) {
            return null;
        }
        //取出count，count减一
        String item = items[count - 1];
        count--;
        return item;
    }
}
