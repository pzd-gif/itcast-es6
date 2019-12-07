package com.zs.lianxi.service.lmpl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.lianxi.dao.TDriverTypeMapper;
import com.zs.lianxi.domain.TDriverType;
import com.zs.lianxi.service.ITDriverTypeService;

@Service
public class TDriverTypeServiceImpl extends 
ServiceImpl<TDriverTypeMapper, TDriverType>
implements ITDriverTypeService{

	@Override
	public TDriverType getIncliudeByCode
	(QueryWrapper<TDriverType> querywrapper) {
		// TODO Auto-generated method stub
		return this.baseMapper.getIncliudeByCode(querywrapper);
	}

}
