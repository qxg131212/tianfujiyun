package com.xg.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//    @HystrixCommand(fallbackMethod = "getMsgfallbace")
    @RequestMapping("/hello1")
    public String hello(){
//        int a = 1/0;   //在正常调用的情况下、我们被调的服务出现问题。就有fallbackMethod的方法返归给调用者；
        return "hello Eureka ! 我是clienta的服务。谢谢调用";
    }

    public String getMsgfallbace(){
        return "你好我们是HytrixCommand服务，起到熔断作用。谢谢";
    }
}
