package com.xg.sms.service;/*

/**
 * @autor qiaoxiaogang
 * @DESCRIPTIN 发送短信接口
 * @create 2019/08/29
 */

import com.xg.sms.entity.SendParam;

public interface SendMes {
    boolean SendMessage(SendParam sendParam);
}
