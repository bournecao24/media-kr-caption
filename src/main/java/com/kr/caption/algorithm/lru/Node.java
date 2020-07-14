package com.kr.caption.algorithm.lru;

/**
 * 链表
 */
public class Node {
    private Node next;
    private Node pre;
    private Object key;
    private Object val;
    private Long updateTime;

    public Node(Node pre, Node next, Object key, Object val) {
        this.pre = pre;
        this.next = next;
        this.key = key;
        this.val = val;
        this.updateTime = System.currentTimeMillis();
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }
}