package com.xg.common;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import javax.swing.text.html.parser.Entity;

public abstract  class BaseFo {

    private int page = 1 ;
    private int limit = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public BaseFo(){}

    public abstract <T extends  BaseEntity> EntityWrapper<T> getEntityWapper();

    public <T extends BaseEntity> Page<T> getPageObj() {
        Page<T> result = new Page(this.page, this.limit);
        return result;
    }
}
