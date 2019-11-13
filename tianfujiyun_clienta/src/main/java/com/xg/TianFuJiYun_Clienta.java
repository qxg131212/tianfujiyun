package com.xg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.test.context.ContextConfiguration;

//@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
        //@HystrixCommand
        // 开启熔断机制
@EnableCircuitBreaker
@SpringBootApplication
@MapperScan("com.xg.dao")
public class TianFuJiYun_Clienta {
    public static void main(String[] args) {
        SpringApplication.run(TianFuJiYun_Clienta.class,args);
    }
}
