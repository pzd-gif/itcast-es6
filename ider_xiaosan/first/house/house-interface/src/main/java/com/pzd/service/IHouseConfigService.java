package com.pzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzd.entity.HouseConfig;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
public interface IHouseConfigService extends IService<HouseConfig> {

    List<Long> getCidsByHid(Long hid);
}
