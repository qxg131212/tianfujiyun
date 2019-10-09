package com.xg.entity;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Data
public class User {

    private  String name;

    private String age;

    private String address;

    private String nian;

    public  User(){};

    public User(String name, String age, String address,String nian) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.nian = nian;
    }

/*    public static void main(String[] args) {
        //转化为时间戳  毫秒值
      long time1 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
       System.out.println(time1);
        long time2 = System.currentTimeMillis();
        System.out.println(time2+"=======");
        //时间戳转化为localdatetime
        DateTimeFormatter df= DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss.SSS");
        System.out.println("+++"+df);
        System.out.println(df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time1), ZoneId.of("Asia/Shanghai"))));
    }*/

/*
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<User> list = new ArrayList<>();
        User user = new User();
        user.setName("99");
        user.setName("92");
        list.add(user);
//        list.stream()
//                .map(User::getName);
        list.stream().forEach(System.out::print);


    }*/

}
