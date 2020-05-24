package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	public PageResult findPage(int pageNum,int pageSize,TbBrand tbBrand);

	public List<TbBrand> findAll();

	public void add(TbBrand tbBrand);

	public void update(TbBrand tbBrand);

	public TbBrand  findOne(Long id);

	public void delete(Long [] ids);
	
}
