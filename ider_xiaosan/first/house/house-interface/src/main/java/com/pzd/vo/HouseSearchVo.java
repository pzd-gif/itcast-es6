package com.pzd.vo;

import com.pzd.metas.DirectionStatus;

import java.io.Serializable;

public class HouseSearchVo implements Serializable {

    //小区名
    private String name;

    //租金
    private Long[] prices;

    //房屋朝向
    private DirectionStatus direction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long[] getPrices() {
        return prices;
    }

    public void setPrices(Long[] prices) {
        this.prices = prices;
    }

    public DirectionStatus getDirection() {
        return direction;
    }

    public void setDirection(DirectionStatus direction) {
        this.direction = direction;
    }
}
