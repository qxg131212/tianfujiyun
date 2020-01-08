package com.xg.entity.fo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xg.entity.User;

import java.io.Serializable;
import java.util.Optional;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class UserFo implements Serializable {

    private static final long serialVersionUID = 1L;
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

    public EntityWrapper getEntityWrapper(){
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.orderBy("u_create_time");
        wrapper.eq("u_delete",0);
        return  wrapper;
    }
}
