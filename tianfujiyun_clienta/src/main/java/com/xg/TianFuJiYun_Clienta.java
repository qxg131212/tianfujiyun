package com.xg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class TianFuJiYun_Clienta {
    public static void main(String[] args) {
        SpringApplication.run(TianFuJiYun_Clienta.class,args);
    }
}
