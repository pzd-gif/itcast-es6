package com.pzd.vo;

import com.pzd.entity.House;

import java.io.Serializable;

public class HouseFormVo implements Serializable {

    private House house;

    private Long[] configIds;

    private Long[] rentIds;

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Long[] getConfigIds() {
        return configIds;
    }

    public void setConfigIds(Long[] configIds) {
        this.configIds = configIds;
    }

    public Long[] getRentIds() {
        return rentIds;
    }

    public void setRentIds(Long[] rentIds) {
        this.rentIds = rentIds;
    }
}
