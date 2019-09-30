package com.xg.controllerfeign.config;

import feign.Logger;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ChuLifeign {

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder getEncoded(){
        return null;
    }

    /**
     * @return  日志
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        System.out.println("Level 日志 ++++++++======");
        return Logger.Level.FULL;
    }

}
