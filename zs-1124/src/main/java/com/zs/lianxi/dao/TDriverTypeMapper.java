package com.zs.lianxi.dao;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zs.lianxi.domain.TDriverType;

public interface TDriverTypeMapper extends BaseMapper<TDriverType>{

	public TDriverType getIncliudeByCode(@Param(Constants.WRAPPER)
	QueryWrapper<TDriverType> querywrapper);
}
