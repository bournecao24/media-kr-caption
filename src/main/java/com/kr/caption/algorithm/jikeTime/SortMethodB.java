package com.kr.caption.algorithm.jikeTime;

import java.util.Arrays;


/**
 * 12  排序（下）：如何用快排思想在O(n)内查找第K大元素
 */
public class SortMethodB {

    /**
     * 归并排序
     * 原理：把数组分为前后两部分，分别对这两部分排序，再把排好序的两部分结合到一起。将一个大问题分解成小问题来解决，小问题解决了，大问题也就解决了
     *
     * @param A
     * @param p
     * @param n
     */
    public void mergeSort(int[] A, int p, int n) {
        mergeSortC(A, 0, n - 1);
        System.out.println(Arrays.toString(A));
    }

    private void mergeSortC(int[] A, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;


        mergeSortC(A, p, q);
        mergeSortC(A, q + 1, r);

        merge(A, p, q, r);

    }

    private void merge(int[] a, int p, int q, int r) {
        if (q == 0) {
            return;
        }
        int leftIndex = p;
        int rightIndex = q + 1;
        int tmpIndex = p;

        int[] tmp = new int[a.length];

        while (leftIndex <= q && rightIndex <= r) {
            if (a[leftIndex] <= a[rightIndex]) {
                tmp[tmpIndex++] = a[leftIndex++];
            } else {
                tmp[tmpIndex++] = a[rightIndex++];
            }
        }

        int start = leftIndex;
        int end = q;
        if (rightIndex <= r) {
            start = rightIndex;
            end = r;
        }

        while (start <= end) {
            tmp[tmpIndex++] = a[start++];
        }

        while (tmpIndex <= r) {
            a[tmpIndex] = tmp[tmpIndex++];
        }
    }

    //归并排序  --end




    /**
     * 快速排序    --start
     * 核心：如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
     * 操作：遍历这组数据，将小于 pivot的元素放到 左边，大于pivot的元素放到右边，pivot放到中间。
     * 结果：分为了三个部分=  p->q-1=小于 pivot的，q+1->r=大于pivot的，pivot。
     * 思想：分治、递归
     *
     * @param a
     * @param n
     */
    private void quickSort(int[] a, int n) {
        quickSortC(a, 0, n - 1);
        System.out.println(Arrays.toString(a));

    }

    private void quickSortC(int[] a, int p, int r) {
        if (p > r) {
            return;
        }

        int q = partition(a, p, r);

        quickSortC(a, p, q - 1);
        quickSortC(a, q + 1, r);

    }

    /**
     * 分区函数
     * 原理：通过游标 i 将数组分为两部分，a[p, i-1] 和 a[i+1, r],左边的区间的元素都是小于 pivot的--已处理区间，右边的都是大于pivot--未处理区间。
     * 每次操作都是从未处理区间取一个元素与pivot对比，如果小于pivot，就将 i 和 j的值互相替换，最后再将 i 的值和 最后一个值互换，再将 i 返回。
     *
     * @param a
     * @param p 这个区间的起点
     * @param r 这个区间的终点
     * @return
     */
    private int partition(int[] a, int p, int r) {

        //一般来说是取最后一个元素作为 pivot
        int pivot = a[r];
        int i = p;

        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }

        //最后这个互换，是为了让pivot到中间去
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        return i;
    }

    //快速排序 --end


    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 10, 7, 2};
        SortMethodB method = new SortMethodB();
        method.quickSort(a, 5);

        method.mergeSort(a, 0, 5);
    }


}
