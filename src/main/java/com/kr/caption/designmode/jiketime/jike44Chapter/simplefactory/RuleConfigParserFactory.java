package com.kr.caption.designmode.jiketime.jike44Chapter.simplefactory;

import com.kr.caption.designmode.jiketime.jike44Chapter.support.IRuleConfigParser;
import com.kr.caption.designmode.jiketime.jike44Chapter.support.JsonRuleConfigParser;
import com.kr.caption.designmode.jiketime.jike44Chapter.support.XmlRuleConfigParser;
import com.kr.caption.designmode.jiketime.jike44Chapter.support.YamlRuleConfigParser;


/**
 * 为了让类的职责更加单一、代码更加清晰，我们还可以进一步将 createParser() 函数剥离 到一个独立的类中，让这个类只负责对象的创建。而这个类就是我们现在要讲的简单工厂模式类。
 */
public class RuleConfigParserFactory {
    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        }
        return parser;
    }
}
