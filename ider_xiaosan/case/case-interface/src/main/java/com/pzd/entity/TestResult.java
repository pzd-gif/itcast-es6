package com.pzd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author pzd
 * @since 2020-03-29
 */
@TableName("tb_test_result")
public class TestResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("cid")
    private Long cid;

    @TableField("result")
    private String result;

    @TableField("status")
    private Integer status;

    @TableField("tester")
    private String tester;

    @TableField("test_time")
    private Date testTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long  getCid() {
        return cid;
    }

    public void setCid(Long  cid) {
        this.cid = cid;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }
    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    @Override
    public String toString() {
        return "TestResult{" +
            "id=" + id +
            ", cid=" + cid +
            ", result=" + result +
            ", status=" + status +
            ", tester=" + tester +
            ", testTime=" + testTime +
        "}";
    }
}
