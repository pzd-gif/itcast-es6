package com.pzd.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pzd.entity.RentDetails;
import com.pzd.service.IRentDetailsService;
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
@RequestMapping("/rent-details")
public class RentDetailsController {

    @Reference
    private IRentDetailsService iRentDetailsService;

    @RequestMapping("list")
    public List<RentDetails> getList(){
        return iRentDetailsService.list();
    }
}
