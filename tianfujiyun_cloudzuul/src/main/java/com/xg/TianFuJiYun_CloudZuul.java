package com.xg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *  网关服务
 */
@SpringBootApplication
//标识它是网关
@EnableZuulProxy
public class TianFuJiYun_CloudZuul {
    public static void main(String[] args) {
        SpringApplication.run(TianFuJiYun_CloudZuul.class,args);
    }
}
