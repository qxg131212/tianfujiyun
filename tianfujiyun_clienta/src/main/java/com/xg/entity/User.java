package com.xg.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

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
}
