package com.kr.caption.designmode.jiketime.jike65Chapter;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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
        return cursor != arrayList.size();
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if (cursor > arrayList.size()) {
            throw new NoSuchElementException();
        }
        return arrayList.get(cursor);
    }


    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");

        ArrayIterator<String> iterator = new ArrayIterator<>(names);
        while (iterator.hasNext()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
