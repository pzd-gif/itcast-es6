package com.pzd.struct;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private List<T> data;
    private long total;

    public PageResult(List<T> data, long total) {
        this.data = data;
        this.total = total;
    }

    public PageResult() {
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public long getTotal() {
        return total;
    }
}

