package com.kr.caption.spring.orginal;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 指明包的名称
 */
@Configuration
@ComponentScan("com.kr.caption")
@ComponentScan(basePackages = {"com.kr.caption.designmode", "com.kr.caption.redis"})
public class CDPlayerConfig {


}
