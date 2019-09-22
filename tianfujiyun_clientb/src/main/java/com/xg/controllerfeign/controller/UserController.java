package com.xg.controllerfeign.controller;

import com.xg.controllerfeign.FeignInteerfaceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private FeignInteerfaceClient feignInteerfaceClient;

    @RequestMapping("/hello")
    public String hello(){
        return  feignInteerfaceClient.Hello();
    }
}
