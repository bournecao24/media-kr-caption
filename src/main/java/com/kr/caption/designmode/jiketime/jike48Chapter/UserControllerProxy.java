package com.kr.caption.designmode.jiketime.jike48Chapter;

import com.kr.caption.designmode.jiketime.jike25Chapter.UserVo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v4.MetricsCollector;


/**
 * 代理类 UserControllerProxy 和原始类 UserController 实现相同的接口 IUserController。
 * UserController 类只负责业务功能。
 * 代理类 UserControllerProxy 负责在业务代码执行前后附加其他逻辑代码，并通过委托的方式调用原始类来执行业务代码。
 */
public class UserControllerProxy implements IUserController {
    private MetricsCollector metricsCollector;
    private UserControllerV2 userController;
    public UserControllerProxy(UserControllerV2 userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVo login(String telephone, String password) {

        long startTimestamp = System.currentTimeMillis();
        // 委托
        UserVo userVo = userController.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {

        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = userController.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return null;
    }
}
