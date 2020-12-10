package com.kr.caption.designmode.jiketime.jike45Chapter;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: caozhenlong
 * @Date: 2020-12-10
 * @Description:
 */
public class XmlBeanConfigParser implements BeanConfigParser{

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = null;
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        return new ArrayList<>();
    }
}
