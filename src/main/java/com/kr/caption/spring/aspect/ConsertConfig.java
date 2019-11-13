package com.kr.caption.spring.aspect;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * 类上面的三个注解用来启动 Aspect 注解
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConsertConfig {


    /**
     *  AspectJ自动代理都会为  使用了这个注解的bean创建一个代理，这个代理会围绕着所有该切面的切点所匹配的 bean，
     * @return
     */
    @Bean
    public Audience audience(){
        return new Audience();
    }

}
