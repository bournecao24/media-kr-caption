package com.kr.caption.designmode.jiketime.jike60Chapter;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *  如果策略类是无状态的，不包含成员变量，只是纯粹的算法实现，这样的策略对象是可以被共享使用的，不需要在每次调用 getStrategy() 的时候，都创建一个新的策略对象
 */
public class StrategyFactory {
    private static final Map<String, Strategy> strategies = new HashMap<>();
    {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }
    public static Strategy getByType(String type){
        if(StringUtils.isBlank(type)){
            throw new IllegalArgumentException("type should not be empty");
        }
        return strategies.get(type);
    }
}
