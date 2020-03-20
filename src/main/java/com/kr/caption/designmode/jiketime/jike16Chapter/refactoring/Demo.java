package com.kr.caption.designmode.jiketime.jike16Chapter.refactoring;

import java.util.List;


//
public class Demo {

    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ... 省略设置 apiStatInfo 数据值的代码

        List<AlertHandler> alertHandlers = ApplicationContext.getInstance().getAlert().getAlertHandlers();
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }
}
