package com.pzd.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzd.entity.House;
import com.pzd.entity.HouseConfig;
import com.pzd.entity.HouseRent;
import com.pzd.mapper.HouseMapper;
import com.pzd.metas.DirectionStatus;
import com.pzd.service.IHouseConfigService;
import com.pzd.service.IHouseRentService;
import com.pzd.service.IHouseService;
import com.pzd.struct.PageResult;
import com.pzd.vo.HouseFormVo;
import com.pzd.vo.HouseSearchVo;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pzd
 * @since 2020-04-08
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {

    @Autowired
    private IHouseConfigService iHouseConfigService;

    @Autowired
    private IHouseRentService iHouseRentService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;



    @Override
    public PageResult<House> getPage(int cp, int pz, HouseSearchVo vo) {
        IPage<House> page = new Page<>(cp,pz);

        QueryWrapper<House> queryWrapper = new QueryWrapper<>();
        if (vo != null){
            String name = vo.getName();
            if (!StringUtils.isEmpty(name)){
                queryWrapper.like("area_name",name);
            }
            Long[] prices = vo.getPrices();
            if (prices!= null && prices.length == 2){
                queryWrapper.between("rent_prices",prices[0],prices[1]);
            }
            DirectionStatus direction = vo.getDirection();
            if (direction != null){
                queryWrapper.eq("direction",direction);
            }
        }
        page = page(page,queryWrapper);
        return new PageResult<>(page.getRecords(),page.getTotal());
    }

    @Override
    public void add(HouseFormVo vo) {
        //添加房源信息
        House house = vo.getHouse();
        save(house);
        Long hid = house.getId();

        //添加中间表
        addMiddle(vo,hid);

        //保存成功后向rocketmq发送信息
        String houseType = house.getRoomNums() + "室"+house.getGuestNums()+"厅"+house.getWashNums()+"卫";
        //往rockeqmq发送消息
        rocketMQTemplate.convertAndSend("inform",house.getAreaName()+","+houseType+","+house.getRentPrice()
        +house.getPaymentMethod().getMsg());
    }

    @Override
    public void del(long id) {
        //删除房源信息
        removeById(id);

        //再删除两个中间表
        delMiddle(id);
    }

    private void delMiddle(long id) {
        QueryWrapper<HouseConfig> houseConfigQueryWrapper = new QueryWrapper<>();
        houseConfigQueryWrapper.eq("hid",id);
        iHouseConfigService.remove(houseConfigQueryWrapper);

        QueryWrapper<HouseRent> houseRentQueryWrapper = new QueryWrapper<>();
        houseRentQueryWrapper.eq("hid",id);
        iHouseRentService.remove(houseRentQueryWrapper);

    }

    @Override
    public void update(HouseFormVo vo) {

        //先修改房源信息
        House house = vo.getHouse();
        updateById(house);
        Long id = house.getId();

        //再删除相关的中间表信息
        delMiddle(id);

        //插入中间表
        addMiddle(vo,id);
    }

    /*
    向中间表添加数据
     */
    private void addMiddle(HouseFormVo vo, Long hid) {
        //添加房屋配置中间表
        Long[] configIds = vo.getConfigIds();
        List<HouseConfig> configs = new ArrayList<>();
        for (Long cid : configIds){
            configs.add(new HouseConfig(hid,cid));
        }
        //批量插入
        iHouseConfigService.saveBatch(configs);

        //添加租金包含中间表
        Long[] rentIds = vo.getRentIds();
        List<HouseRent> rents = new ArrayList<>();
        for (Long rid : rentIds){
            rents.add(new HouseRent(hid,rid));
        }
        //批量插入
        iHouseRentService.saveBatch(rents);

    }
}
