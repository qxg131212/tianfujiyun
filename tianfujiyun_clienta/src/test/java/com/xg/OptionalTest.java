package com.xg;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xg.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalTest {

    @Test
    public void Optional() {
        LocalDate date = LocalDate.now();       // 获取当前时间年月日 例如：2019-10-16
        int year = date.getYear();             //获取当前年， .2019
        int monthValue = date.getMonthValue(); //获取当前月份，不需要加1.新版特性； 10
        int dayOfMonth = date.getDayOfMonth();  //获得天数
        System.out.println(year+"=="+monthValue);
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUname("华府" + i);
            user.setNian(i + "年");
            user.setAddress(i + "号");
            user.setAge("1" + i);
            list.add(user);
        }
        Optional<ArrayList<User>> present = Optional.ofNullable(list);
        System.out.println(present + "==");

        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.like("uname","af".trim()).or("").like("uage","10");
        wrapper.orderBy("uname desc");

    }


}
