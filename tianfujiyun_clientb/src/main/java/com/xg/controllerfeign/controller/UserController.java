package com.xg.controllerfeign.controller;

import com.xg.controllerfeign.FeignInterfaceClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "pifu",description = "test")
public class UserController {

    @Autowired
    private FeignInterfaceClient feignInterfaceClient;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ApiOperation(value = "查找用户", notes = "查找用户")
    public String hello(HttpServletRequest request){
        //60s过期
        long lo = System.currentTimeMillis() + 60000;
        String ss = "nihao woyizhuce";
        request.getSession().setAttribute("exp",lo);
        request.getSession().setAttribute("cc",ss);
        return  feignInterfaceClient.Hello();
    }
}
