package com.kr.caption.designmode.jiketime.jike62Chapter.use;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-28
 * @Description:
 */
public class SensitiveWordFilterChain {

    private List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter) {
        this.filters.add(filter);
    }

    public Boolean filter(String content) {

        for (SensitiveWordFilter filter : filters) {
            if (!filter.doFilter(content)) {
                return false;
            }
        }
        return true;
    }
}
