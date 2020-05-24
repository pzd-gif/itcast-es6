package com.pzd.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.pzd.entity.TestResult;
import com.pzd.entity.TestResultVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pzd
 * @since 2020-03-29
 */
@Mapper
public interface TestResultMapper extends BaseMapper<TestResult> {
    List<TestResultVo> getVo(@Param(Constants.WRAPPER)QueryWrapper<TestResultVo> queryWrapper);
}
