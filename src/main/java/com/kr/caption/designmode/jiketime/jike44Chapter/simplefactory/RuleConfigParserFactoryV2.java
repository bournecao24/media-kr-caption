package com.kr.caption.designmode.jiketime.jike44Chapter.simplefactory;

import com.kr.caption.designmode.jiketime.jike44Chapter.support.IRuleConfigParser;
import com.kr.caption.designmode.jiketime.jike44Chapter.support.JsonRuleConfigParser;
import com.kr.caption.designmode.jiketime.jike44Chapter.support.XmlRuleConfigParser;
import com.kr.caption.designmode.jiketime.jike44Chapter.support.YamlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果 parser 可以复用，为了节省内存和对象创建的时间，我们可以将 parser 事先创建好缓存起来。当调用 createParser() 函数的时候，我们从缓存中取出 parser 对象直接使用。
 */
public class RuleConfigParserFactoryV2 {
    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();
    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
    }
    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            //返回null还是IllegalArgumentException全凭你自己说了算
            return null;
        }
        return cachedParsers.get(configFormat.toLowerCase());
    }
}

