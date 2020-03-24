package com.xg.utils;

public class ObjectResResponse<T> extends BaseResponse {

    T  data;

    public ObjectResResponse() {
    }

    public ObjectResResponse data(T data) {
        this.setData(data);
        return this;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
