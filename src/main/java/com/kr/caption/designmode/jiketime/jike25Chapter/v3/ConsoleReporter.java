package com.kr.caption.designmode.jiketime.jike25Chapter.v3;

import com.kr.caption.designmode.jiketime.jike25Chapter.v2.MetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestStat;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsoleReporter {

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer statViewer;
    private ScheduledExecutorService executorService;

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer statViewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statViewer = statViewer;
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
                statViewer.output(requestStats, startTimeInMillis, endTimeInMillis);

            }
        }, 0L, periodInSeconds, TimeUnit.SECONDS);
    }
}
