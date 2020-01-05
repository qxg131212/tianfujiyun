package com.xg.entity.fo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xg.entity.User;

import java.util.Optional;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class UserFo {
    /**
     *查询字段name
     */
    private String name;

    /**
     *查询字段 年龄
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserFo(){
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.orderBy("u_create_time");
    }
}
