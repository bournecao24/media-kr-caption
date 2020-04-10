package com.kr.caption.designmode.jiketime.jike60Chapter;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果策略类是有状态的，根据业务场景的需要，我们希望每次从工厂方法中，获得的都是新创建的策略对象，而不是缓存好可共享的策略对象
 */
public class StrategyFactoryV2 {
    private static final Map<String, Strategy> strategies = new HashMap<>();
    public static Strategy getByType(String type){
        if(StringUtils.isBlank(type)){
            throw new IllegalArgumentException("type should not be empty");
        }
        if(type.equals("A")){
            return new ConcreteStrategyA();
        }else if(type.equals("B")){
            return new ConcreteStrategyB();
        }
        return null;
    }
}
