package com.xg.entity;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "init";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

}
