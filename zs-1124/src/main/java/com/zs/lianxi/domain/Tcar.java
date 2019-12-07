package com.zs.lianxi.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 车辆表
 * </p>
 *
 * @author guanyu
 * @since 2019-11-23
 */
public class Tcar implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 车辆名称
     */
    @TableField("name")
    private String name;

    /**
     * 品牌
     */
    @TableField("trademark")
    private String trademark;

    /**
     * 日租金
     */
    @TableField("rent")
    private String rent;

    /**
     * 最低准驾车型
     */
    @TableField("car_type")
    private String carType;

    /**
     * 图片
     */
    @TableField("pic_url")
    private String picUrl;

    /**
     * 发布时间
     */
    @TableField("created")
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }
    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "TCar{" +
            "id=" + id +
            ", name=" + name +
            ", trademark=" + trademark +
            ", rent=" + rent +
            ", carType=" + carType +
            ", picUrl=" + picUrl +
            ", created=" + created +
        "}";
    }
}
