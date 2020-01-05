package com.xg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
// 开启测试文档
@EnableSwagger2
//@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
        //@HystrixCommand
        // 开启熔断机制
@EnableCircuitBreaker
@SpringBootApplication
@MapperScan("com.xg.dao")
public class TianFuJiYun_Clienta extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(TianFuJiYun_Clienta.class,args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE")
                .allowedOrigins("*");
    }
}
