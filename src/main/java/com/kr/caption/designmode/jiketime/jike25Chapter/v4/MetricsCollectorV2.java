package com.kr.caption.designmode.jiketime.jike25Chapter.v4;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.MetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Executors;


/**
 * 问题：采集和存储要异步来执行，因为存储基于外部存储(比如 Redis)，会比较慢，异步存 储可以降低对接口响应时间的影响
 * 解决：通过在 MetricsCollector 中引入 Google Guava EventBus 来解决。实际上，我们可以把 EventBus 看作一个“生产者 - 消费者”模型或者“发布 - 订阅”模型，
 * 采集的数据先放入内存共享队列中，另一个线程读取共享队列中的数据，写入到外部存储(比如 Redis)中
 */
public class MetricsCollectorV2 {

    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;

    private MetricsStorage metricsStorage;
    private EventBus eventBus;

    public MetricsCollectorV2(MetricsStorage metricsStorage, int threadNumToSaveDat) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveDat));
        this.eventBus.register(new EventListener());
    }


    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public MetricsCollectorV2(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }


    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }

        eventBus.post(requestInfo);
    }

    
    public class EventListener {

        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }

}
