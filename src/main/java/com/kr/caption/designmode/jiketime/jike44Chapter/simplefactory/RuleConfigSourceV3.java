package com.kr.caption.designmode.jiketime.jike44Chapter.simplefactory;

import com.kr.caption.designmode.jiketime.jike44Chapter.support.*;

/**
 * 根据配置文件的后缀(json、xml、yaml、properties)，选择不 同的解析器(JsonRuleConfigParser、XmlRuleConfigParser......)，将存储在文件中的 配置解析成内存对象 RuleConfig。
 */
public class RuleConfigSourceV3 {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        if (parser == null){
            throw new IllegalArgumentException("Rule config file format is not supported: " + ruleConfigFilePath);
        }

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
