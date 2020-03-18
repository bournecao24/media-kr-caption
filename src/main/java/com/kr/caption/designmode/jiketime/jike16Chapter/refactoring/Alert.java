package com.kr.caption.designmode.jiketime.jike16Chapter.refactoring;


import java.util.ArrayList;
import java.util.List;

/**
 * 第一部分是将 check() 函数的多个入参封装成 ApiStatInfo 类;
 * 第二部分是引入 handler 的概念，将 if 判断逻辑分散在各个 handler 中。
 */
public class Alert {

    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addHandler(AlertHandler handler){
        this.alertHandlers.add(handler);
    }

}
