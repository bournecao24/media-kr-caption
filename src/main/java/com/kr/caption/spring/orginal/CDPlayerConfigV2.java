package com.kr.caption.spring.orginal;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 用Java代码装配bean
 */
@Configuration
public class CDPlayerConfigV2 {

    @Bean
    public Compactdic sgtPeppers(){
        return new SgtPeppers();
    }
}
