package com.xg.entity;


import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

public class Impl {

    @Autowired
    private User user;

    public T test(Fo fo){
        //根据条件分页查询（page，fo）；
       return  new T();
    }
}
