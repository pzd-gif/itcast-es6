package com.pzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzd.entity.Case;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pzd
 * @since 2020-03-29
 */
public interface ICaseService extends IService<Case> {
    void updateByStatus(Long id,Integer status);
}
