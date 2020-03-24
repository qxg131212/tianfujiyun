package com.xg.utils;

import java.util.List;

public class TableResultResponse<T> extends BaseResponse {
    TableResultResponse<T>.TableData<T> data;
    public TableResultResponse() {
        this.data = new TableResultResponse.TableData();
    }
    public TableResultResponse(long total, List<T> rows){
        this.data = new TableResultResponse.TableData(total,rows);
    }

    TableResultResponse<T> total(int total) {
        this.data.setTotal((long)total);
        return this;
    }

    TableResultResponse<T> total(List<T> rows) {
        this.data.setRows(rows);
        return this;
    }
    public TableResultResponse<T>.TableData<T> getData() {
        return this.data;
    }
    public void setData(TableResultResponse<T>.TableData<T> data) {
        this.data = data;
    }

    public class TableData<T> {
        long total;
        List<T> rows;

        public TableData(long this$0, List<T> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData() {
        }
        //TableData类的set 和 get 方法


        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<T> getRows() {
            return rows;
        }

        public void setRows(List<T> rows) {
            this.rows = rows;
        }
    }
}
