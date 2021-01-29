package com.kr.caption.designmode.jiketime.jike62Chapter.use;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-28
 * @Description:
 */
public class SexyWordFilter implements SensitiveWordFilter {
    @Override
    public Boolean doFilter(String content) {
        boolean legal = true;

        //...
        return legal;
    }
}
