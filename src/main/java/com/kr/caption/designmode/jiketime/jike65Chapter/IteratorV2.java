package com.kr.caption.designmode.jiketime.jike65Chapter;

/**
 * 返回当前元素与后移一位这两个操作，要放到同一个函数 next() 中完成
 *
 * @Author: caozhenlong
 * @Date: 2021-01-29
 * @Description:
 */
public interface IteratorV2<R> {

    boolean hasNext();

    R next();
}
