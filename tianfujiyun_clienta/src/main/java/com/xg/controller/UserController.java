package com.xg.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xg.common.BaseResponse;
import com.xg.common.TableResultResponse;
import com.xg.entity.User;
import com.xg.entity.fo.UserFo;
import com.xg.entity.fo.UsersFo;
import com.xg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "User表操作",value = "/hr/clienta")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有
     * @return 乔小刚
     */
    @PostMapping(name="获取page人员",value = "/getAllUsers")
    public TableResultResponse getAllUsers(@RequestBody UserFo userFo){
        return userService.getAllUser(userFo);
    }

    @GetMapping(name = "逻辑删除",value = "/delectUserId/{id}")
    public BaseResponse delectUserId(@PathVariable("id") String id){
        return userService.delectUserId(id);
    }

    @PostMapping(name="更新and 新增", value = "/updaeteOrInsert")
    public BaseResponse updaeteOrInsert(@RequestBody UsersFo usersFo) {
        return userService.updateOrInsert(usersFo);
    }







//    @HystrixCommand(fallbackMethod = "getMsgfallbace")
    @GetMapping("/hello1")
    public String hello(){
//        int a = 1/0;   //在正常调用的情况下、我们被调的服务出现问题。就有fallbackMethod的方法返归给调用者；
        return "hello Eureka ! 我是clienta的服务。谢谢调用";
    }

    public String getMsgfallbace(){
        return "你好我们是HytrixCommand服务，起到熔断作用。谢谢";
    }


}
