package com.kr.caption.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
