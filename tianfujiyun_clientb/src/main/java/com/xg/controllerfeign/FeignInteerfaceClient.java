package com.xg.controllerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "TIANFUJIYUNCLIENTA")
//@FeignClient(name = "TIANFUJIYUNCLIENTA",configuration = ServiceFeignInterceptor.class,fallback = 接口impl.class)
public interface FeignInteerfaceClient {

    //远程调用 TIANFUJIYUN_CLIENTA，也就是tianfujiyun_clienta服务的接口；
    @RequestMapping("/hello")
    public String Hello();

}
