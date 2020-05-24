package com.pzd.struct;

import java.io.Serializable;

public class Result implements Serializable {
    private Integer status;
    private String msg;

    public Result() {
    }

    public Result(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
