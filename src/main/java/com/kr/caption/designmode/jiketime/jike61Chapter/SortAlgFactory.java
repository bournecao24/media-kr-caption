package com.kr.caption.designmode.jiketime.jike61Chapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-27
 * @Description:
 */
public class SortAlgFactory {

    private static final Map<String, ISortAlg> algs = new HashMap<>();

    static {
        algs.put("QuickSort", new QuickSort());
        algs.put("ExternalSort", new ExternalSort());
    }

    public static ISortAlg getSortAlg(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return algs.get(type);
    }
}
