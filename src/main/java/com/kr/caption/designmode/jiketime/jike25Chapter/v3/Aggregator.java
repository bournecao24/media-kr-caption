package com.kr.caption.designmode.jiketime.jike25Chapter.v3;

import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 在重构之后，我们将每个统计逻辑拆分成独立的函数， aggregate() 函数变得比较单薄，可读性提高了。
 * 尽管我们要添加新的统计功能，还是要修 改 aggregate() 函数，但现在的 aggregate() 函数代码行数很少，结构非常清晰，修改起来更加容易，可维护性提高。
 */
public class Aggregator {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInMillis / 1000));
        return requestStat;
    }

    // 以下的函数的代码实现均省略...
    private double max(List<Double> dataset) {
        return 0d;
    }

    private double min(List<Double> dataset) {
        return 0d;
    }

    private double avg(List<Double> dataset) {
        return 0d;
    }

    private double tps(int count, double duration) {
        return 0d;
    }

    private double percentile999(List<Double> dataset) {
        return 0d;
    }

    private double percentile99(List<Double> dataset) {
        return 0d;
    }

    private double percentile(List<Double> dataset, double ratio) {
        return 0d;
    }
}
