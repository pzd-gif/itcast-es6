package com.zs.lianxi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 司机信息表
 * </p>
 *
 * @author guanyu
 * @since 2019-11-23
 */
public class TDriver implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 司机姓名
     */
   // @NotNull(message="姓名不能为空")
    @TableField("name")
    private String name;

    /**
     * 手机
     */
   //@Size(min=11,max=11,message="手机号必须为11位")
    @TableField("phone")
    private String phone;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 驾驶证号
     */
    @TableField("driver_license")
    private String driverLicense;

    /**
     * 驾驶证等级
     */
    @TableField("drive_type")
    private String driveType;

    /**
     * 发证日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("issued")
    private Date issued;

    /**
     * 注册时间
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
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }
    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }
    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "TDriver{" +
            "id=" + id +
            ", name=" + name +
            ", phone=" + phone +
            ", password=" + password +
            ", driverLicense=" + driverLicense +
            ", driveType=" + driveType +
            ", issued=" + issued +
            ", created=" + created +
        "}";
    }
}
