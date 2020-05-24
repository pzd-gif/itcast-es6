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
@TableName("t_house_config")
public class HouseConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("hid")
    private Long hid;

    @TableField("cid")
    private Long cid;

    public HouseConfig(Long hid, Long cid) {

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
    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "HouseConfig{" +
            "id=" + id +
            ", hid=" + hid +
            ", cid=" + cid +
        "}";
    }
}
