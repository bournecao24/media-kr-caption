package com.kr.caption.designmode.jiketime.jike65Chapter.v2;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-29
 * @Description:
 */
public class ArrayList<E> implements List<E>{

    public int modCount;

    public ArrayList() {
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator(this);
    }
}
