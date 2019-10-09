package com.xg.controllerfeign.config;

import feign.Logger;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
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
        System.out.println("+========="+"Encode编码");
        return new SpringFormEncoder();
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
