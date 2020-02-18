package com.kr.caption;

import com.kr.caption.spring.aspect.AudienceV4;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestClassV2 {

    public static void main(String[] args) {

        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application_example.xml"));

        AudienceV4 audience =(AudienceV4) xmlBeanFactory.getBean("audience");
        System.out.println(audience);

    }
}
