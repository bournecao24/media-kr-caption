package com.kr.caption.designmode.jiketime.jike65Chapter.v3;

/**
 *在容器中，为每个元素保存两个时间戳，一个是添加时间戳 addTimestamp，一个是删除时间戳 delTimestamp。
 * 当元素被加入到集合中的时候，我们将 addTimestamp 设置为当前时间，将 delTimestamp 设置成最大长整型 （Long.MAX_VALUE）。
 * 当元素被删除时，我们将 delTimestamp 更新为当前时间，表示已经被删除。<br>同时，每个迭代器也保存一个迭代器创建时间戳 snapshotTimestamp，也就是迭代器对应的快照的创建时间戳。
 * 当使用迭代器来遍历容器的时候，只有满足 addTimestamp<snapshotTimestamp<delTimestamp 的元素，才是属于这个迭代器的快照。
 */
public class SnapshotArrayIteratorV3<E> implements IteratorV3<E> {
    private long snapshotTimestamp;
    private int cursorInAll; // 在整个容器中的下标，而非快照中的下标
    private int leftCount; // 快照中还有几个元素未被遍历
    private ArrayListV3<E> arrayList;

    public SnapshotArrayIteratorV3(ArrayListV3<E> arrayList) {
        this.snapshotTimestamp = System.currentTimeMillis();
        this.cursorInAll = 0;
        this.leftCount = arrayList.actualSize();

        this.arrayList = arrayList;
        justNext(); // 先跳到这个迭代器快照的第一个元素
    }

    public boolean hasNext() {
        return this.leftCount >= 0; // 注意是>=, 而非>
    }

    public E next() {
        E currentItem = arrayList.get(cursorInAll);
        justNext();
        return currentItem;
    }

    @Override
    public E currentItem() {
        return null;
    }

    private void justNext() {
        while (cursorInAll < arrayList.totalSize()) {
            long addTimestamp = arrayList.getAddTimestamp(cursorInAll);
            long delTimestamp = arrayList.getDelTimestamp(cursorInAll);
            if (snapshotTimestamp > addTimestamp && snapshotTimestamp < delTimestamp) leftCount--;
            break;
        }
        cursorInAll++;
    }
}

