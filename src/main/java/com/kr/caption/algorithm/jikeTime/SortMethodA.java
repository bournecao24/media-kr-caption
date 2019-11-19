package com.kr.caption.algorithm.jikeTime;


import java.util.Arrays;

/**
 * 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？
 */
public class SortMethodA {


    /**
     * 冒泡排序
     * 操作：一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
     * 场景：适合小规模的数据排序
     * @param a
     * @param n
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                    // 表示有数据交换
                }
            }
            if (!flag) break;
            // 没有数据交换，提前退出
        }
    }


    /**
     * 插入排序
     * 一个有序的数组，如果再往数组里加一个元素，依然保持有序，怎么做？遍历整个数组，放到该放的位子上，这个一个动态排序，如果是静态呢？
     * 分为两个区间，一个已排序区间，一个未排序区间，初始的已排序区间只有一个元素，就是数组的第一个。
     * 核心思想：取未排序中的元素，在已排序区间中找到合适位置插入，并保证有序的那个区间一直有序
     * 场景：适合小规模的数据排序
     * @param a
     * @param n
     */
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }



    public static void main(String[] args) {

        SortMethodA sortMethodA = new SortMethodA();

        int [] a  =  new int [] {2,4,5,6,7,3,6,0};
        sortMethodA.insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));


    }


}
