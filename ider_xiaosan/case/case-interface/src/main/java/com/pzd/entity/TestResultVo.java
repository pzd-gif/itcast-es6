package com.pzd.entity;

public class TestResultVo extends TestResult{
    private String caseNum;
    private String caseDesc;
    private String expect;

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
}
