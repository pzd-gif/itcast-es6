package com.zs.lianxi.service.lmpl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.lianxi.dao.TCarMapper;
import com.zs.lianxi.domain.Tcar;
import com.zs.lianxi.service.ITCarService;
@Service
public class TCarServicelmpl extends ServiceImpl<TCarMapper, Tcar>
implements ITCarService{

}
