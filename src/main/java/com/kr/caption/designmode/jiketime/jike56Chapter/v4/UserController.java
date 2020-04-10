package com.kr.caption.designmode.jiketime.jike56Chapter.v4;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.kr.caption.designmode.jiketime.jike56Chapter.v2.RegObserver;
import com.kr.caption.designmode.jiketime.jike56Chapter.v2.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


/**
 * 基于 EventBus，我们不需要定义 Observer 接口， 任意类型的对象都可以注册到 EventBus 中，通过 @Subscribe 注解来标明类中哪个函数 可以接收被观察者发送的消息。
 */
public class UserController {
    private UserService userService; // 依赖注入
    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;
    public UserController() {
        //eventBus = new EventBus(); // 同步阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE)); //异步非堵塞
    }
    private List<RegObserver> regObservers = new ArrayList<>();
    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }
    public Long register(String telephone, String password) { //省略输入参数的校验代码 //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        eventBus.post(userId);
        return userId;
    }
}
