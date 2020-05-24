package com.pzd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
@TableName("t_house_rent")
public class HouseRent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("hid")
    private Long hid;

    @TableField("rid")
    private Long rid;

    public HouseRent(Long hid, Long rid) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "HouseRent{" +
            "id=" + id +
            ", hid=" + hid +
            ", rid=" + rid +
        "}";
    }
}
