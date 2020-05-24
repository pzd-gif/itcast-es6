package com.pzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzd.entity.House;
import com.pzd.struct.PageResult;
import com.pzd.vo.HouseFormVo;
import com.pzd.vo.HouseSearchVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
public interface IHouseService extends IService<House> {

    //分页 HouseSearchVo vo 这个是模糊查询用到的类
    PageResult<House> getPage(int cp, int pz, HouseSearchVo vo);

    //添加 HouseFormVo vo 这个是用于添加或者修改中间表重新新建了一个类
    void add(HouseFormVo vo);

    //删除
    void del(long id);

    //修改
    void update(HouseFormVo vo);
}
