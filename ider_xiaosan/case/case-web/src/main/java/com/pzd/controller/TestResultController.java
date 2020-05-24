package com.pzd.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pzd.entity.TestResult;
import com.pzd.entity.TestResultVo;
import com.pzd.service.ITestResultService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pzd
 * @since 2020-03-29
 */
@RestController
@RequestMapping("/test-result")
public class TestResultController {
    @Reference
    private ITestResultService iTestResultService;

    @RequestMapping("insert")
    public int insert(@RequestBody TestResult testResult){
        int i = iTestResultService.insert(testResult);
        return i;
    }

    @RequestMapping("list")
    public List<TestResultVo> getList(String tester, String caseDesc){
        return iTestResultService.getList(tester,caseDesc);
    }
}
