package com.pzd.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pzd.entity.Case;
import com.pzd.service.ICaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pzd
 * @since 2020-03-29
 */
@RestController
@RequestMapping("/case")
public class CaseController {

    @Reference
    private ICaseService iCaseService;

    @RequestMapping("list")
    public List<Case> getList(){
        return iCaseService.list();
    }
}
