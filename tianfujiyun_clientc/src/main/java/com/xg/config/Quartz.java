package com.xg.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Quartz {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    int count = 0;
//    @Scheduled(fixedRate = 6000) //6000相当于6秒时间
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

    //     @Scheduled(cron="*/6 * * * * ?")  //通用定时表达式。网络一搜一大片；
    private void process() {
        System.out.println("this is scheduler task runing  " + (count++));
    }

}
