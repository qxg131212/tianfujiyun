package com.xg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
        //@HystrixCommand
        // 开启熔断机制
@EnableCircuitBreaker
@ContextConfiguration({"/com/xg/dao"})
public class TianFuJiYun_Clienta {
    public static void main(String[] args) {
        SpringApplication.run(TianFuJiYun_Clienta.class,args);
    }
}
