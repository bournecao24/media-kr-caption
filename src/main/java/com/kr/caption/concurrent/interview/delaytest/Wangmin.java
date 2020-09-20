package com.kr.caption.concurrent.interview.delaytest;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


/**
 * DelayQueue是一个支持延时获取元素的无界阻塞队列。队列使用PriorityQueue来实现。队列中的元素必须实现Delayed接口，在创建元素时可以指定多久才能从队列中获取当前元素。只有在延迟期满时才能从队列中提取元素。我们可以将DelayQueue运用在以下应用场景：
 * 缓存系统的设计：可以用DelayQueue保存缓存元素的有效期，使用一个线程循环查询DelayQueue，一旦能从DelayQueue中获取元素时，表示缓存有效期到了。
 * 定时任务调度。使用DelayQueue保存当天将会执行的任务和执行时间，一旦从DelayQueue中获取到任务就开始执行，从比如TimerQueue就是使用DelayQueue实现的。
 * 队列中的元素必须实现Delayed接口，实现CompareTo方法。比如让延时时间最长的放在队列的末尾
 */
public class Wangmin implements Delayed {

    private String name;
    //身份证
    private String id;
    //截止时间
    private long endTime;
    //定义时间工具类
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    public Wangmin(String name, String id, long endTime) {
        this.name = name;
        this.id = id;
        this.endTime = endTime;
    }


    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    /**
     * 用来判断是否到了截止时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        //return unit.convert(endTime, TimeUnit.MILLISECONDS) - unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        return endTime - System.currentTimeMillis();
    }

    /**
     * 相互批较排序用
     */
    @Override
    public int compareTo(Delayed delayed) {
        Wangmin w = (Wangmin) delayed;
        return this.getDelay(this.timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1 : 0;
    }
}
