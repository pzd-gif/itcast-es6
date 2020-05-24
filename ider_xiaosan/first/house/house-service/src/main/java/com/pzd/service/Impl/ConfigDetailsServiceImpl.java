package com.pzd.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzd.entity.ConfigDetails;
import com.pzd.mapper.ConfigDetailsMapper;
import com.pzd.service.IConfigDetailsService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
@Service
public class ConfigDetailsServiceImpl extends ServiceImpl<ConfigDetailsMapper, ConfigDetails> implements IConfigDetailsService {

}
