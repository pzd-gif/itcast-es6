package com.pzd.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pzd.entity.ConfigDetails;
import com.pzd.service.IConfigDetailsService;
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
@RequestMapping("/config-details")
public class ConfigDetailsController {

    @Reference
    private IConfigDetailsService iConfigDetailsService;

    @RequestMapping("list")
    public List<ConfigDetails> getList(){

        return iConfigDetailsService.list();
    }
}
