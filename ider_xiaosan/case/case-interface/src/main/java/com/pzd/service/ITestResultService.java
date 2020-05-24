package com.pzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzd.entity.TestResult;
import com.pzd.entity.TestResultVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pzd
 * @since 2020-03-29
 */
public interface ITestResultService extends IService<TestResult> {
    int insert(TestResult testResult);

    List<TestResultVo> getList(String tester,String caseDesc);
}
