package com.xg.entity;


import com.xg.entity.fo.UserFo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

public class Impl {

    @Autowired
    private User user;

    public T test(UserFo fo){
        //根据条件分页查询（page，fo）；
       return  new T();
    }
}
