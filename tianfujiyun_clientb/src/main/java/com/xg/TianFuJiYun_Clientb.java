package com.xg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
//Eureka客户端
@EnableEurekaClient
//开启远程服务调用
@EnableFeignClients
//开启熔断
@EnableCircuitBreaker
public class TianFuJiYun_Clientb {
    public static void main(String[] args) {
        SpringApplication.run(TianFuJiYun_Clientb.class,args);
    }

//   rabbon   标注他开启负载均衡 和调用的接口RestTemple一起使用；
  /*  @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }*/

  @Bean
    public CorsFilter corsFilter(){
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedOrigin("*");
      config.addAllowedHeader("*");
      config.addAllowedMethod("OPTIONS");
      config.addAllowedMethod("HEAD");
      config.addAllowedMethod("GET");
      config.addAllowedMethod("PUT");
      config.addAllowedMethod("POST");
      config.addAllowedMethod("DELETE");
      config.addAllowedMethod("PATCH");
      source.registerCorsConfiguration("/**",config);
      return new CorsFilter(source);  //主要jia包不要导错；
  }



}
