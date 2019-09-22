package com.xg;

import com.xg.controllerfeign.FeignInteerfaceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFeign {

    @Autowired
    private FeignInteerfaceClient feignInteerfaceClient;



    @Test
    public void getHelloFeign(){
        for(int i=0;i<10;i++) {
            String hello = feignInteerfaceClient.Hello();
            System.out.println(hello);
        }
    }

    /**
     *  目前已被feign优化使用中 在文件中开启<!--ribben的jia包-->
     *            <dependency>
     *                 <groupId>org.springframework.cloud</groupId>
     *                 <artifactId>spring-cloud-starter-ribbon</artifactId>
     *                 <version>1.1.5.RELEASE</version>
     *            </dependency>
     *            <dependency>
     *                <groupId>com.squareup.okhttp3</groupId>
     *                <artifactId>okhttp</artifactId>
     *               <version>3.9.1</version>
     *           </dependency>
     */
/*
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getHello(){
        //serviceId 是 其他项目注册在Eureka的名字；
        String serviceId = "TIANFUJIYUNCLIENTA";
        String forObject = restTemplate.getForObject("http://"+serviceId+"/hello",String.class);
        System.out.println(forObject+"=================");
    }
*/


}








