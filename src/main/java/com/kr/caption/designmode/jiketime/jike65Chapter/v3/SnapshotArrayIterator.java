package com.kr.caption.designmode.jiketime.jike65Chapter.v3;

import com.kr.caption.designmode.jiketime.jike65Chapter.v2.Iterator;

import java.util.ArrayList;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-31
 * @Description:
 */
public class SnapshotArrayIterator<E> implements Iterator<E> {
    private int cursor;
    private ArrayList<E> snapshot;

    public SnapshotArrayIterator(ArrayList<E> snapshot) {
        this.cursor = 0;
        this.snapshot = new ArrayList<>();
        this.snapshot.addAll(snapshot);
    }

    @Override
    public boolean hasNext() {
        return cursor < snapshot.size();
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        E currentItem = snapshot.get(cursor);
        cursor++;
        return currentItem;
    }
}
