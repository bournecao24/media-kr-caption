package com.kr.caption.designmode.jiketime.jike25Chapter.v3;

import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestStat;

import java.util.Map;

public class ConsoleViewer implements StatViewer {
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long durationInMillis) {
        System.out.println("");
    }
}
