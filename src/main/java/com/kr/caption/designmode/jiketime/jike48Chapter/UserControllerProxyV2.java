package com.kr.caption.designmode.jiketime.jike48Chapter;

import com.kr.caption.designmode.jiketime.jike25Chapter.UserVo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v4.MetricsCollector;


public class UserControllerProxyV2 extends UserController {
    private MetricsCollector metricsCollector;
    public UserControllerProxyV2() {
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // 委托
        UserVo userVo = super.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = super.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return null;
    }
}
