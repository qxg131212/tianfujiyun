package com.xg.sms.controller;
/**
 * @Autor qiaoxiaogang
 * @DESCRIPTIN 发送短信接口
 * @create 2019/08/29
 */

import com.xg.sms.entity.SendParam;
import com.xg.sms.service.SendMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor qiaoxiaogagn
 * @Distripitation 此处的测试代码在test中，整个ssm模块加jia包即可实现短信业务
 */

@RestController
@RequestMapping(value = {"/"})
//@Api(value = "ssm",description = "测试SmsController")
public class SmsController {

    private  final String CODE = ""+(int)((Math.random()*9+1)*1000);

    @Autowired
    private SendMes sendMes;

    @PostMapping(value = "sms")
//    @ApiOperation(value = "短信", notes = "短信")
    public Boolean sms(@RequestBody SendParam sendParam){
        sendParam.setCode(CODE);
        return sendMes.SendMessage(sendParam);
    }
}
