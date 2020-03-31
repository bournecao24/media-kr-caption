package com.kr.caption.designmode.jiketime.jike44Chapter.factorymethod;

import java.util.HashMap;
import java.util.Map;

/**
 * 我们可以为工厂类再创建一个简单工厂，也就是工厂的工厂，用来创建工厂类对象
 */
public class RuleConfigParserFactoryMap {
    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();
    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
    }
    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return cachedFactories.get(type.toLowerCase());
    }
}
