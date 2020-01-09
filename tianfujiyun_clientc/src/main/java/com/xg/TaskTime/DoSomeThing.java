package com.xg.TaskTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoSomeThing implements ApplicationRunner {
    //日指定义
    Logger LOGGER = LoggerFactory.getLogger(DoSomeThing.class);

    @Scheduled(cron = "*/5 * * * * ?") // 5秒一次的干活
    public void SomeThing(){
        LOGGER.info("加工开始时间"+ LocalDate.now());
        List<Object> list = new ArrayList<>();
        ArrayList<Object> list1 = list.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("To  do  -");
    }

    //实现App后重写的方法。
    @Override
    public void run(ApplicationArguments args) throws Exception {
        SomeThing();
    }
}
