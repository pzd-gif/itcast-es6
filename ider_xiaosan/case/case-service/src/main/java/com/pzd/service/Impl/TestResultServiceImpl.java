package com.pzd.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzd.entity.TestResult;
import com.pzd.entity.TestResultVo;
import com.pzd.mapper.TestResultMapper;
import com.pzd.service.ICaseService;
import com.pzd.service.ITestResultService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pzd
 * @since 2020-03-29
 */
@Service
public class TestResultServiceImpl extends ServiceImpl<TestResultMapper, TestResult> implements ITestResultService {

    @Autowired
    private ICaseService iCaseService;

    @Override
    public int insert(TestResult testResult) {
        save(testResult);

        iCaseService.updateByStatus(testResult.getCid(),testResult.getStatus());
        return 200;
    }

    @Override
    public List<TestResultVo> getList(String tester, String caseDesc) {
        QueryWrapper<TestResultVo> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(tester)){
            queryWrapper.like("a,tester",tester);
        }
        if (!StringUtils.isEmpty(caseDesc)){
            queryWrapper.like("b.case_desc",caseDesc);
        }
        List<TestResultVo> list = baseMapper.getVo(queryWrapper);

        return list;
    }
}
