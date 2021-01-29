package com.kr.caption.designmode.jiketime.jike65Chapter;

/**
 * next() 函数用来将游标后移一位元素，currentItem() 函数用来返回当前游标指向的元素。
 *
 * 这种方式比较灵活，可以多次获取当前游标指向的元素，而不用移动游标
 *
 * @Author: caozhenlong
 * @Date: 2021-01-29
 * @Description:
 */
public interface Iterator<E> {

    boolean hasNext();

    void next();

    E currentItem();

}
