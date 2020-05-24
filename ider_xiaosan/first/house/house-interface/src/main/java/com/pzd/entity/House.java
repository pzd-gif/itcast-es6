package com.pzd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pzd.metas.DirectionStatus;
import com.pzd.metas.PayTypeStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
@TableName("t_house")
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("area_name")
    private String areaName;

    @TableField("room_nums")
    private Integer roomNums;

    @TableField("wash_nums")
    private Integer washNums;

    @TableField("guest_nums")
    private Integer guestNums;

    @TableField("total_area")
    private Double totalArea;

    @TableField("direction")
    private DirectionStatus direction;

    @TableField("rent_price")
    private BigDecimal rentPrice;

    @TableField("payment_method")
    private PayTypeStatus paymentMethod;

    @TableField("rent_date")
    private LocalDate rentDate;

    @TableField("pic_rul")
    private String picRul;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getRoomNums() {
        return roomNums;
    }

    public void setRoomNums(Integer roomNums) {
        this.roomNums = roomNums;
    }

    public Integer getWashNums() {
        return washNums;
    }

    public void setWashNums(Integer washNums) {
        this.washNums = washNums;
    }

    public Integer getGuestNums() {
        return guestNums;
    }

    public void setGuestNums(Integer guestNums) {
        this.guestNums = guestNums;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public DirectionStatus getDirection() {
        return direction;
    }

    public void setDirection(DirectionStatus direction) {
        this.direction = direction;
    }

    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    public PayTypeStatus getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PayTypeStatus paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public String getPicRul() {
        return picRul;
    }

    public void setPicRul(String picRul) {
        this.picRul = picRul;
    }

    @Override
    public String toString() {
        return "House{" +
            "id=" + id +
            ", areaName=" + areaName +
            ", roomNums=" + roomNums +
            ", washNums=" + washNums +
            ", guestNums=" + guestNums +
            ", totalArea=" + totalArea +
            ", direction=" + direction +
            ", rentPrice=" + rentPrice +
            ", paymentMethod=" + paymentMethod +
            ", rentDate=" + rentDate +
            ", picRul=" + picRul +
        "}";
    }
}
