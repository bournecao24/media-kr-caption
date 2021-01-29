package com.kr.caption.designmode.jiketime.jike65Chapter.v2;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-29
 * @Description:
 */
public class ArrayIterator<E> implements Iterator<E> {

    private int cursor;
    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
//        return cursor != arrayList.size();
        return false;
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
//        if (cursor > arrayList.size()) {
//            throw new NoSuchElementException();
//        }
//        return arrayList.get(cursor);
        return null;
    }

}
