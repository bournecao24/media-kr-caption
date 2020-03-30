package com.kr.caption.designmode.jiketime.jike25Chapter.v4;

import com.kr.caption.designmode.jiketime.jike25Chapter.v2.MetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RedisMetricsStorage;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;

import java.util.ArrayList;

public class PerfCounterTestV2 {


    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();

        // 定时触发统计并将结果显示到终端
        ConsoleReporter consoleReporter = new ConsoleReporter();
        consoleReporter.startRepeatedReport(60, 60);

        // 定时触发统计并将结果输出到邮件
        ArrayList<String> addressList = new ArrayList<>();
        addressList.add("wangzheng@xzg.com");
        EmailReporter emailReporter = new EmailReporter(addressList);
        emailReporter.startDailyReport();

        // 收集接口访问数据
        MetricsCollector collector = new MetricsCollector();
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
