package com.xg.common;

import net.sf.jsqlparser.schema.Table;

import java.util.List;

public class TableResultResponse<T> extends BaseResponse {
    private TableResultResponse<T>.TableData<T> data;

    public TableResultResponse() {
        this.data = new TableResultResponse.TableData();
    }

    public TableResultResponse(long total, List<T> rows) {
        this.data = new TableResultResponse.TableData(total,rows);
    }

    TableResultResponse<T> total(int total){
        this.data.setTotal((long) total);
        return this;
    }

    TableResultResponse<T> total(List<T> rows){
        this.data.setRows(rows);
        return this;
    }

    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
        this.data = data;
    }

    public class TableData<T>{
        private long total;

        private List<T> rows;

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

        public TableData(long total, List<T> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData() {}
    }
}
