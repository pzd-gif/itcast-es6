package com.pzd.metas;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum PayTypeStatus implements Serializable {

    ONE_ONE(1,"押一付一"),
    ONE_THREE(2,"押一付三"),
    TWO_THREE(3,"押二付三")
    ;

    private int code;

    private String msg;

    PayTypeStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @JsonValue
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
