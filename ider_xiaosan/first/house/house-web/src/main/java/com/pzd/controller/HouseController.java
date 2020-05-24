package com.pzd.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pzd.entity.House;
import com.pzd.service.IHouseService;
import com.pzd.struct.PageResult;
import com.pzd.struct.Result;
import com.pzd.vo.HouseFormVo;
import com.pzd.vo.HouseSearchVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/house")
public class HouseController {

    @Reference
    private IHouseService iHouseService;

    @RequestMapping("list")
    public PageResult<House> getList(int cp, int pz, @RequestBody HouseSearchVo vo){
        return iHouseService.getPage(cp,pz,vo);
    }

    @RequestMapping("add")
    public Result add(@RequestBody HouseFormVo vo){
        try {
            iHouseService.add(vo);
            return new Result(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(500,"添加失败");
        }
    }

    @RequestMapping("del")
    public Result del(long id){
        try {
            iHouseService.del(id);
            return new Result(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(500,"删除失败");
        }
    }

    @RequestMapping("update")
    public Result update(@RequestBody HouseFormVo vo){
        try {
            iHouseService.update(vo);
            return new Result(200,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(500,"修改失败");
        }
    }
}
