package com.kr.caption.algorithm.jikeTime;

/**
 * from 极客时间 7
 * 关于哨兵模式
 */
public class DataSructure {


    /**
     * 在数组 a 中，查找 key，返回 key 所在的位置
     *
     * @param a
     * @param n
     * @param key
     * @return
     */
    private int find(int[] a, int n, int key) {
        if (a == null || a.length <= 0) {
            return -1;
        }

        int i = 0;
        while (i < n) {
            if (a[i] == key) {
                return i;
            }

            ++i;
        }
        return -1;
    }


    private int findV2(int[] a, int n, int key) {
        if (a == null || a.length <= 0) {
            return -1;
        }

        //这里因为要将 a[n-1] 的值替换成 key，所以要特殊处理
        if (a[n - 1] == key) {
            return n - 1;
        }

        //新建变量，保存 a[n-1]，这里做的原因就是希望这个方法不会改变数组的值
        int tmp = a[n - 1];
        a[n - 1] = key;

        int i = 0;
        //while 循环比起代码一，少了 i<n的操作
        while (a[i] != key) {
            ++i;
        }

        a[n - 1] = tmp;
        if (i == n - 1) {
            return -1;
        } else {
            return i;
        }
    }

}
