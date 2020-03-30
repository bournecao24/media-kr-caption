package com.kr.caption.designmode.jiketime.jike25Chapter.v4;

import com.kr.caption.designmode.jiketime.jike25Chapter.v2.MetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RedisMetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;
import org.apache.commons.lang3.StringUtils;

public class MetricsCollector {
    private MetricsStorage metricsStorage;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public MetricsCollector() {
        this(new RedisMetricsStorage());
    }

    ;

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }


    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }

        metricsStorage.saveRequestInfo(requestInfo);
    }


}
