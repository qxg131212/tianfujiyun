package com.xg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//Eureka客户端
@EnableEurekaClient
//启动定时任务
@EnableScheduling   //此注解只需要和@Component注解配合使用即可。无需繁琐的jia包之类的其余操作。即可起到定时跟新东西；
public class TianFuJiYun_Clientc {

    public static void main(String[] args) {
        SpringApplication.run(TianFuJiYun_Clientc.class,args);
    }
}
