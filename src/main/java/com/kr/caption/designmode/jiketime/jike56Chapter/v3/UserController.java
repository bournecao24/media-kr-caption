package com.kr.caption.designmode.jiketime.jike56Chapter.v3;

import com.kr.caption.designmode.jiketime.jike56Chapter.v2.RegObserver;
import com.kr.caption.designmode.jiketime.jike56Chapter.v2.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class UserController {
    private UserService userService; // 依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();
    private Executor executor;
    public UserController(Executor executor) {
        this.executor = executor;
    }
    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }
    public Long register(String telephone, String password) { //省略输入参数的校验代码 //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        for (RegObserver observer : regObservers) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observer.handleRegSuccess(userId);
                }
            });
        }
        return userId;
    }
}
