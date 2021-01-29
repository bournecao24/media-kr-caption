package com.kr.caption.designmode.jiketime.jike61Chapter;

import java.io.File;

public class SorterV2 {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) { // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg = new ExternalSort();
        if (fileSize < 6 * GB) {
            // [0, 6GB)
            sortAlg = SortAlgFactory.getSortAlg("QuickSort");
        } else if (fileSize < 10 * GB) {
            // [6GB, 10GB)
            sortAlg = SortAlgFactory.getSortAlg("ExternalSort");
        } else if (fileSize < 100 * GB) {
            // [10GB, 100GB)
            sortAlg = SortAlgFactory.getSortAlg("ConcurrentExternalSort");
        }

        sortAlg.sort(filePath);
    }
}
