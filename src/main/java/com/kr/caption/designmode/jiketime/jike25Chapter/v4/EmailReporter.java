package com.kr.caption.designmode.jiketime.jike25Chapter.v4;

import com.kr.caption.designmode.jiketime.jike25Chapter.v2.MetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RedisMetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v3.Aggregator;
import com.kr.caption.designmode.jiketime.jike25Chapter.v3.EmailViewer;
import com.kr.caption.designmode.jiketime.jike25Chapter.v3.StatViewer;

import java.util.*;

public class EmailReporter extends ScheduledReporter {

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }

    //兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public EmailReporter(List<String> emailToAddresses) {
        this(new RedisMetricsStorage(), new Aggregator(), new EmailViewer());
    }



    public void startDailyReport() {
        Date firstTime = trimTimeFieldsToZeroOfNextDay();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;

                doStatAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }


    /**
     * 简单的代码抽离成 trimTimeFieldsToZeroOfNextDay() 函数之后，虽然代码更加清晰了， 一眼就能从名字上知道这段代码的意图(获取当前时间的下一天的 0 点时间)，
     * 但我们发现这个函数的可测试性仍然不好，因为它强依赖当前的系统时间。实际上，这个问题挺普遍的。
     * 一般的解决方法是，将强依赖的部分通过参数传递进来，这有点类似我们之前讲的依赖注入。
     *
     * @return
     */
    protected Date trimTimeFieldsToZeroOfNextDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 再次重构
     *
     * @param date
     * @return
     */
    protected Date trimTimeFieldsToZeroOfNextDay(Date date) {
        Calendar calendar = Calendar.getInstance(); // 这里可以获取当前时间
        calendar.setTime(date); // 重新设置时间

        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();

    }
}