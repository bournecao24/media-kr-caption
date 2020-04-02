package com.kr.caption.designmode.jiketime.jike48Chapter;

import com.kr.caption.designmode.jiketime.jike25Chapter.UserVo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v4.MetricsCollector;


/**
 * 第一，性能计数器框架代码侵入到业务代码中，跟业务代 码高度耦合。如果未来需要替换这个框架，那替换的成本会比较大。
 * 第二，收集接口请求的 代码跟业务代码无关，本就不应该放到一个类中。业务类最好职责更加单一，只聚焦业务处理。
 */
public class UserController {
    //...省略其他属性和方法...
    private MetricsCollector metricsCollector; // 依赖注入

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // ... 省略login逻辑... 9
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        //...返回UserVo数据...
        return new UserVo();
    }

    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // ... 省略register逻辑... 22
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return new UserVo();
    }
}