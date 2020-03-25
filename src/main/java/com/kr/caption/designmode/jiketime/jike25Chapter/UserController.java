package com.kr.caption.designmode.jiketime.jike25Chapter;

import java.util.concurrent.TimeUnit;

public class UserController {


    private Metrics metrics = new Metrics();

    public UserController(Metrics metrics) {
        metrics.startRepeatedReport(60, TimeUnit.SECONDS);
    }


    public void register(UserVo user) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("regsiter", startTimestamp);
        //...
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("register", respTime);
    }
}