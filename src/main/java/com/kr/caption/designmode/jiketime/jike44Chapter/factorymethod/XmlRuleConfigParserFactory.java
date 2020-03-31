package com.kr.caption.designmode.jiketime.jike44Chapter.factorymethod;

import com.kr.caption.designmode.jiketime.jike44Chapter.support.IRuleConfigParser;
import com.kr.caption.designmode.jiketime.jike44Chapter.support.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements  IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
