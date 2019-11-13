package com.kr.caption.spring.orginal;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * 指明包的名称
 */
@Configuration
@Profile("dev")
@ComponentScan("com.kr.caption")
@ComponentScan(basePackages = {"com.kr.caption.designmode", "com.kr.caption"})
public class CDPlayerConfig {


}
