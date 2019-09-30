package com.xg.controllerfeign.impl;

import com.xg.controllerfeign.FeignInterfaceClient;
import org.springframework.stereotype.Component;

@Component
public class FeignInterfaceClientImpl implements FeignInterfaceClient {
    @Override
    public String Hello() {
        System.out.println("实现了路径");
        return null;
    }
}
