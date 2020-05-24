package com.pzd.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzd.entity.HouseRent;
import com.pzd.mapper.HouseRentMapper;
import com.pzd.service.IHouseRentService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
@Service
public class HouseRentServiceImpl extends ServiceImpl<HouseRentMapper, HouseRent> implements IHouseRentService {

    @Override
    public List<Long> getRidsByHid(Long hid) {
        //查询条件
        QueryWrapper<HouseRent> rentQueryWrapper = new QueryWrapper<>();
        rentQueryWrapper.eq("hid",hid);

        List<HouseRent> list = list(rentQueryWrapper);

        ArrayList<Long> result = new ArrayList<>();
        list.forEach(item -> result.add(item.getRid()));
        return result;
    }
}
