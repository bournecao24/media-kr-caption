package com.kr.caption.designmode.jiketime.jike25Chapter.v3;

import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestStat;

import java.util.Map;

public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long durationInMillis);
}
