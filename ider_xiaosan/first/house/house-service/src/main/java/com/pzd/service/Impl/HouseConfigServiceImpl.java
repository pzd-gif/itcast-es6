package com.pzd.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzd.entity.HouseConfig;
import com.pzd.mapper.HouseConfigMapper;
import com.pzd.service.IHouseConfigService;

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
public class HouseConfigServiceImpl extends ServiceImpl<HouseConfigMapper, HouseConfig> implements IHouseConfigService {

    @Override
    public List<Long> getCidsByHid(Long hid) {
        //查询条件
        QueryWrapper<HouseConfig> configQueryWrapper = new QueryWrapper<>();
        configQueryWrapper.eq("hid",hid);

        //获取数据
        List<HouseConfig> list = list(configQueryWrapper);

        //遍历，获取cid
        List<Long> result = new ArrayList<>();
        list.forEach(item -> result.add(item.getCid()));

        return result;
    }
}
