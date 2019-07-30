package com.kr.caption.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Configuration  表明这个类是一个配置类，应该在Spring中
 * @Bean  表明该方法会返回一个对象，并且该对象会注册到Spring上下文中，当然了也可以自己去命名，Spring会拦截所有对此方法的调用，并确保直接返回该方法创建的bean，
 * 而不是每次都会真的调用
 *
 * anotherWater 和 water 会返回完全一样的bean，默认情况下，Spring中的bean都是单例的，所以这两个方法会得到对象
 */
@Configuration
public class TrainConfig {
    @Bean
    public Transport train(){
        return new Train(water());
    }

    @Bean
    public Water water(){
        return new Water();
    }

    @Bean
    public Water anotherWater(){
        return new Water();
    }
}
