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
 * @since 2020-03-29
 */
@TableName("tb_case")
public class Case implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("case_num")
    private String caseNum;

    @TableField("case_desc")
    private String caseDesc;

    @TableField("expect")
    private String expect;

    @TableField("function_moudel")
    private String functionMoudel;

    @TableField("all_num")
    private Integer allNum;

    @TableField("success_num")
    private Integer successNum;

    @TableField("fail_num")
    private Integer failNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }
    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc;
    }
    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }
    public String getFunctionMoudel() {
        return functionMoudel;
    }

    public void setFunctionMoudel(String functionMoudel) {
        this.functionMoudel = functionMoudel;
    }
    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }
    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }
    public Integer getFailNum() {
        return failNum;
    }

    public void setFailNum(Integer failNum) {
        this.failNum = failNum;
    }

    @Override
    public String toString() {
        return "Case{" +
            "id=" + id +
            ", caseNum=" + caseNum +
            ", caseDesc=" + caseDesc +
            ", expect=" + expect +
            ", functionMoudel=" + functionMoudel +
            ", allNum=" + allNum +
            ", successNum=" + successNum +
            ", failNum=" + failNum +
        "}";
    }
}
