package com.pzd.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzd.entity.Case;
import com.pzd.mapper.CaseMapper;
import com.pzd.service.ICaseService;

/**
 * <p>
 *  服务实现类注解是不是错啦！！ 改一下
 * </p>
 *
 * @author pzd
 * @since 2020-03-29
 */
@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case> implements ICaseService {

    @Override
    public void updateByStatus(Long id, Integer status) {
        Case c = getById(id);

        c.setAllNum(c.getAllNum());

        if (status == 0){
            c.setFailNum(c.getFailNum());
        }else {
            c.setSuccessNum(c.getSuccessNum());
        }
        updateById(c);
    }
}
