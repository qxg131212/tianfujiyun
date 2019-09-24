package com.xg.controllerfeign.controller;

import com.xg.controllerfeign.FeignInteerfaceClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "pifu",description = "test")
public class UserController {

    @Autowired
    private FeignInteerfaceClient feignInteerfaceClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ApiOperation(value = "查找用户", notes = "查找用户")
    public String hello(){
        return  feignInteerfaceClient.Hello();
    }
}
