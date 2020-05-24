package com.pzd.metas;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DirectionStatus {
    SN(1,"南北通透"),
    EW(2,"东西朝向"),
    ;

    private int code;

    private String msg;

    DirectionStatus(int code, String msg) {
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
