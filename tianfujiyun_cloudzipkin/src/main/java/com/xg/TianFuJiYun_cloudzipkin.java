package com.xg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class TianFuJiYun_cloudzipkin {
    public static void main(String[] args) {
        //暂时未配置好‘
        SpringApplication.run(TianFuJiYun_cloudzipkin.class,args);
    }
}
