package com.pzd.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pzd.service.IHouseRentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/house-rent")
public class HouseRentController {

    @Reference
    private IHouseRentService iHouseRentService;

    @RequestMapping("list")
    public List<Long> getRidsByHid(Long hid){
        return iHouseRentService.getRidsByHid(hid);
    }
}
