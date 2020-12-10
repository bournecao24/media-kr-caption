package com.kr.caption.designmode.jiketime.jike45Chapter;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: caozhenlong
 * @Date: 2020-12-10
 * @Description:
 */
public interface BeanConfigParser {

    List<com.kr.caption.designmode.jiketime.jike45Chapter.BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContent);



}
