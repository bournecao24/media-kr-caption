package com.kr.caption.designmode.jiketime.jike44Chapter.factorymethod;

import com.kr.caption.designmode.jiketime.jike44Chapter.support.IRuleConfigParser;
import com.kr.caption.designmode.jiketime.jike44Chapter.support.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements  IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
