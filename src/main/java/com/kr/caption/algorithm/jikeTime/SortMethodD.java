package com.kr.caption.algorithm.jikeTime;


/**
 * 15 | 二分查找（上）：如何用最省内存的方式实现快速查找功能？
 */
public class SortMethodD {


    /**
     * 最简单的情况是：有序数组中不存在重复元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            //如果low和high比较大的情况下，得到的结果可能会溢出，所以：low + （high - low）/2
            //除以2这里可以改成位运算= low+((high-low)>>1)
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    /**
     * 递归实现
     * @param a
     * @param n
     * @param val
     * @return
     */
    public int bsearchV2(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid =  low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid+1, high, value);
        } else {
            return bsearchInternally(a, low, mid-1, value);
        }
    }
}
