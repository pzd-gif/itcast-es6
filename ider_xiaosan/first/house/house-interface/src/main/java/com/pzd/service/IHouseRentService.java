package com.pzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzd.entity.HouseRent;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
public interface IHouseRentService extends IService<HouseRent> {

    List<Long> getRidsByHid(Long hid);
}
