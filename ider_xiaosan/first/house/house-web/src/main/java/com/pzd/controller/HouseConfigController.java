package com.pzd.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pzd.service.IHouseConfigService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/house-config")
public class HouseConfigController {

    @Reference
    private IHouseConfigService iHouseConfigService;

    @RequestMapping("list")
    public List<Long> getCidsByHid(Long hid){
        return iHouseConfigService.getCidsByHid(hid);
    }
}
