package com.kr.caption.designmode.jiketime.jike44Chapter.factorymethod;

import com.kr.caption.designmode.jiketime.jike44Chapter.support.IRuleConfigParser;
import com.kr.caption.designmode.jiketime.jike44Chapter.support.YamlRuleConfigParser;


public class YamlRuleConfigParserFactory implements  IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
