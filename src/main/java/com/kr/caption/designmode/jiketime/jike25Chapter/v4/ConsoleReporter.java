package com.kr.caption.designmode.jiketime.jike25Chapter.v4;

import com.kr.caption.designmode.jiketime.jike25Chapter.v2.MetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RedisMetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestStat;
import com.kr.caption.designmode.jiketime.jike25Chapter.v3.Aggregator;
import com.kr.caption.designmode.jiketime.jike25Chapter.v3.ConsoleViewer;
import com.kr.caption.designmode.jiketime.jike25Chapter.v3.StatViewer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsoleReporter extends ScheduledReporter {
    private ScheduledExecutorService executorService;


    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public ConsoleReporter() {
        this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
    }

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
        this.executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
                viewer.output(requestStats, startTimeInMillis, endTimeInMillis);

            }
        }, 0L, periodInSeconds, TimeUnit.SECONDS);
    }
}
