package com.xg.controllerfeign;

import com.xg.controllerfeign.config.ChuLifeign;
import com.xg.controllerfeign.impl.FeignInterfaceClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Autor qiaoxiaogang
 * name：指定FeignClient的名称，如果项目使用了Ribbon，name属性会作为微服务的名称，用于服务发现
 * url: url一般用于调试，可以手动指定@FeignClient调用的地址
 * decode404:当发生http 404错误时，如果该字段位true，会调用decoder进行解码，否则抛出FeignException
 * configuration: Feign配置类，可以自定义Feign的Encoder、Decoder、LogLevel、Contract
 * fallback: 定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑，fallback指定的类必须实现@FeignClient标记的接口
 */
//@FeignClient(value = "TIANFUJIYUNCLIENTA")
@FeignClient(name = "TIANFUJIYUNCLIENTA", configuration = ChuLifeign.class,  fallback = FeignInterfaceClientImpl.class)
public interface FeignInterfaceClient {

    //远程调用 TIANFUJIYUN_CLIENTA，也就是tianfujiyun_clienta服务的接口；
    @RequestMapping("/hello")
    public String Hello();

}
