package com.zs.lianxi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.lianxi.domain.TDriverType;

public interface ITDriverTypeService extends IService<TDriverType>{
	public TDriverType getIncliudeByCode(
	QueryWrapper<TDriverType> querywrapper);
}
