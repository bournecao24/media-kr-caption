package com.kr.caption.algorithm.jikeTime;

public class SortMethod {


    // 冒泡排序，a表示数组，n表示数组大小
    //适合小规模的数据排序
    //一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
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


    //插入排序
    //适合小规模的数据排序
    //例子：一个有序的数组，如果再往数组里加一个元素，依然保持有序，怎么做？遍历整个数组，放到该放的位子上，这个一个动态排序，如果是静态呢？
    // a表示数组，n表示数组大小
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


    // 归并排序算法, A是数组，n表示数组大小
    //待完善
    public void mergeSort() {

//        merge_sort(A, n) {
//            merge_sort_c(A, 0, n - 1)
//        }
//
//        // 递归调用函数
//        merge_sort_c(A, p, r) {
//            // 递归终止条件
//            if p >= r then return
//
//                    // 取p到r之间的中间位置q
//                    q = (p + r) / 2
//            // 分治递归
//            merge_sort_c(A, p, q)
//            merge_sort_c(A, q + 1, r)
//            // 将A[p...q]和A[q+1...r]合并为A[p...r]
//            merge(A[p...r],A[p...q],A[q + 1...r])
//        }



//如图所示，我们申请一个临时数组 tmp，大小与 A[p…r] 相同。我们用两个游标 i 和 j，分别指向 A[p…q] 和 A[q+1…r] 的第一个元素。比较这两个元素 A[i] 和 A[j]，如果 A[i]<=A[j]，我们就把 A[i] 放入到临时数组 tmp，并且 i 后移一位，否则将 A[j] 放入到数组 tmp，j 后移一位。继续上述比较过程，直到其中一个子数组中的所有数据都放入临时数组中，再把另一个数组中的数据依次加入到临时数组的末尾，这个时候，临时数组中存储的就是两个子数组合并之后的结果了。最后再把临时数组 tmp 中的数据拷贝到原数组 A[p…r] 中。
//        merge(A[p...r], A[p...q], A[q+1...r]) {
//            var i := p，j := q+1，k := 0 // 初始化变量i, j, k
//            var tmp := new array[0...r-p] // 申请一个大小跟A[p...r]一样的临时数组
//            while i<=q AND j<=r do {
//                if A[i] <= A[j] {
//                    tmp[k++] = A[i++] // i++等于i:=i+1
//                } else {
//                    tmp[k++] = A[j++]
//                }
//            }
//
//            // 判断哪个子数组中有剩余的数据
//            var start := i，end := q
//            if j<=r then start := j, end:=r
//
//            // 将剩余的数据拷贝到临时数组tmp
//            while start <= end do {
//                tmp[k++] = A[start++]
//            }
//
//            // 将tmp中的数组拷贝回A[p...r]
//            for i:=0 to r-p do {
//                A[p+i] = tmp[i]
//            }
//        }


    }

}
