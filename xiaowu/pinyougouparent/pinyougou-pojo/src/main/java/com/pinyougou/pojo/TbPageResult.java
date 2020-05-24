package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.List;

public class TbPageResult implements Serializable {
    private Long total;

    private List rows;

    public TbPageResult(long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
}
