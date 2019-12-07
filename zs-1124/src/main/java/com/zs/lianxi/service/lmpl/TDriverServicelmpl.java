package com.zs.lianxi.service.lmpl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.lianxi.dao.TDriverMapper;
import com.zs.lianxi.domain.TDriver;
import com.zs.lianxi.service.ITDriverService;
@Service
public class TDriverServicelmpl extends ServiceImpl<TDriverMapper, TDriver>
implements ITDriverService{

}
