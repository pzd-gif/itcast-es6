package com.pinyougou.pojo;

import java.io.Serializable;

public class Result implements Serializable {

    private boolean success;
    private String message;
    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }
}
