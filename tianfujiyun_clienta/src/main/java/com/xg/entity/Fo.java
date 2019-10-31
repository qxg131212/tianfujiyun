package com.xg.entity;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.Optional;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class Fo {
    /**
     *查询字段
     */
    private String queryString;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public Fo(){
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.like("uname","小明   ".trim()).or("").like("uage","10");
        wrapper.orderBy("uname desc");
    }
}
