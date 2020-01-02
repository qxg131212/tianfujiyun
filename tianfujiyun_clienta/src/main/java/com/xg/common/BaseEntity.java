package com.xg.common;

import javax.persistence.Id;

public class BaseEntity {

    @Id
    private String id;

    public BaseEntity(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
