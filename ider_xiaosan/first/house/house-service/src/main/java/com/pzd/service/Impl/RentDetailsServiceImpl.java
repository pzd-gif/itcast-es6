package com.pzd.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzd.entity.RentDetails;
import com.pzd.mapper.RentDetailsMapper;
import com.pzd.service.IRentDetailsService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
@Service
public class RentDetailsServiceImpl extends ServiceImpl<RentDetailsMapper, RentDetails> implements IRentDetailsService {

}
