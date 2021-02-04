package com.kr.caption.designmode.jiketime.jike82Chapter;

import com.google.common.collect.ForwardingCollection;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 *  AddLoggingCollection 是基于代理模式实现的一个代理类，它在原始 Collection 类的基础之上，针对“add”相关的操作，添加了记录日志的功能。
 *
 * @Author: caozhenlong
 * @Date: 2021-02-03
 * @Description:
 */
@Slf4j
public class AddLoggingCollection<E> extends ForwardingCollection<E> {

    private Collection<E> originalCollection;

    public AddLoggingCollection(Collection<E> originalCollection) {
        this.originalCollection = originalCollection;
    }

    @Override
    protected Collection<E> delegate() {
        return this.originalCollection;
    }

    @Override
    public boolean add(E element) {
        log.info("Add element: " + element);
        return this.delegate().add(element);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        log.info("Size of elements to add: " + collection.size());
        return this.delegate().addAll(collection);
    }
}
